package com.exampI.proyecto5.vista

import android.app.SearchManager
import android.database.Cursor
import android.database.MatrixCursor
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.cursoradapter.widget.CursorAdapter
import androidx.cursoradapter.widget.SimpleCursorAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.exampI.proyecto5.R
import com.exampI.proyecto5.databinding.FragmentTiendaBinding
import com.exampI.proyecto5.viewmodel.TiendaFragmentViewModel


class TiendaFragment : Fragment() {
    private lateinit var binding: FragmentTiendaBinding
    private lateinit var viewModel: TiendaFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarViewModel()
        inicializarToolbar()
        inicializarRecyclerView()
        return binding.root
    }

    fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentTiendaBinding.inflate(inflater, container, false)
    }

    fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(TiendaFragmentViewModel::class.java)
        val context = requireContext()
        viewModel.cargarProductos(context)
        Log.d("LISTA PRODUCTOS", viewModel.productos.toString())
    }

    fun inicializarToolbar() {

        //1º parte: reemplazamos la "toolbar antigua" por nuestra material toolbar
        val mainActivity: MainActivity = activity as MainActivity
        mainActivity.setSupportActionBar(binding.materialToolbar)

        //2º parte: poner el menú del archivo menu_toolbar.xml
        mainActivity.addMenuProvider(object : MenuProvider {

            //Este metodo coge el parametro "menu" y le pone el menu del archivo menu_toolbar.xml, que obtenemos gracias al parametro "menuInflater"
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_toolbar, menu)
                val txtBuscador: SearchView =
                    menu.findItem(R.id.txtBuscardor).actionView as SearchView
                inicializarBuscador(txtBuscador)
            }

            //Este método recibe coo parametro un "menuItem" que ha sido pulsado y ejecuta el código fuente correspondiente
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.btnMostrarTodos -> {
                        Toast.makeText(requireContext(), "Pulsado mostrar todos", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                return true
            }

        })
    }

    fun inicializarRecyclerView() {
        //creamos un producto adapter
        val adapter = ProductoAdapter(viewModel.productos) { holder ->
            Toast.makeText(
                requireContext(),
                "Has pulsado ${holder.producto.nombre}",
                Toast.LENGTH_LONG
            ).show()
        }

        //le ponemos el adapter al RecyclerView
        binding.lstResultados.adapter = adapter
    }

    fun getSugerecias(texto: String): Cursor {
        val cursor = MatrixCursor(arrayOf(BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1))
        viewModel.productos
            .map { p -> p.nombre }
            .filter { n -> n.contains(texto, ignoreCase = true) }
            .distinct()
            .forEachIndexed { index, s -> cursor.addRow(arrayOf(index, s)) }
        return cursor
    }

    fun getCursorAdapter(): CursorAdapter {
        return SimpleCursorAdapter(
            requireContext(),
            R.layout.sugerencia,
            null,
            arrayOf(SearchManager.SUGGEST_COLUMN_TEXT_1),
            intArrayOf(R.id.txtSugerencia),
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        )
    }

    private fun inicializarBuscador(buscador: SearchView) {
        buscador.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(texto: String?): Boolean {
                consultar(texto)
                return true
            }

            override fun onQueryTextChange(texto: String?): Boolean {
                return true
            }
        })
    }

    private fun consultar(texto: String?) {
        var lista = viewModel.productos
        if (texto != null) {
            lista = viewModel.productos
                .filter { p -> p.nombre.contains(texto, ignoreCase = true) }
        }
        val adapter = binding.lstResultados.adapter as ProductoAdapter
        adapter.setListaProductos(lista)
    }


}