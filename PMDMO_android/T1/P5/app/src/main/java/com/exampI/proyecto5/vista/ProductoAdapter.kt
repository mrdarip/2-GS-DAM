package com.exampI.proyecto5.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exampI.proyecto5.databinding.ProductoBinding
import com.exampI.proyecto5.modelo.Producto

/*

    Esta clase le proporciona al RecyclerView los objetos
    que necesita coolocar en los ProductoHolder

    El constructor necesita dos parámetros:
    1) La lista de productos
    2) El código fuente que se activa cuando se pulsa el ProductoHolder
*/

class ProductoAdapter(
    var productos:List<Producto>,
    val lambda: (ProductoHolder) -> Unit
) : RecyclerView.Adapter<ProductoHolder>(){

    fun setListaProductos(lista:List<Producto>){
        productos = lista
        //hacemos que el RecyclerView se redibuje los nuevos productos
        notifyDataSetChanged()
    }

    //El objetico de este método es crear un objeto ProductoHolder y devolverlo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        //esta linea permite obtener un inflater
        val inflater = LayoutInflater.from(parent.context)
        //usamos el inflater y el paren para inicializar la mochila binding de "producto.xml"
        val mochilaBinding = ProductoBinding.inflate(inflater, parent, false)
        return ProductoHolder(mochilaBinding)
    }

    //devuelve el número de productos de la tienda
    override fun getItemCount(): Int = productos.size

    /*
        Este método pone en el ProductoHolder pasado como primer parámetro
        el producto que ocupa la posición "position" de la lista de productos
    */

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        //obtenemos el producto que hay que mostrar en el "holder"
        val producto = productos.get(position)
        //ponemos en "holder" el producto obtenido
        holder.mostrarProducto(producto)
        //opcional (casi siempres se hace)
        //hacemos que al pulsar en el elemento root del holder, se active la lambda
        holder.binding.root.setOnClickListener{
            //activo la lambda y le paso como parámetro "holder"
            lambda(holder)
        }
    }
}