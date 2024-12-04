package com.exampi.proyecto6.vista

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.exampi.proyecto6.databinding.FragmentResultadoBinding
import com.exampi.proyecto6.viewmodel.ResultadoFragmentViewModel

class ResultadoFragment : Fragment() {
    lateinit var binding: FragmentResultadoBinding
    lateinit var viewModel: ResultadoFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initializeBinding(inflater, container)
        initializeViewModel()
        initializeRecyclerView()

        return binding.root
    }

    private fun initializeRecyclerView() {
        binding.lstResultados.adapter =
            CifradoAdapter(
                viewModel.listaCifrados,
                viewModel.listaResultados
            ) { holder ->
                var mensaje = holder.binding.textView3.text.toString()

                //Intent para compartir el mensaje
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, mensaje)
                    type = "text/plain"
                }
                requireContext().startActivity(sendIntent)
            }
    }

    private fun initializeBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentResultadoBinding.inflate(inflater, container, false)
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(ResultadoFragmentViewModel::class.java)
        viewModel.mensaje = ResultadoFragmentArgs.fromBundle(requireArguments()).mensaje
        viewModel.inicializarCifrados(ResultadoFragmentArgs.fromBundle(requireArguments()).listacifrados)
        viewModel.cifrarMensaje(viewModel.mensaje)
    }
}