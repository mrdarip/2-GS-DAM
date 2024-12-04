package com.exampi.proyecto6.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.navigation.fragment.findNavController
import com.exampi.proyecto6.R
import com.exampi.proyecto6.databinding.FragmentMensajeBinding

class MensajeFragment : Fragment() {
    lateinit var binding: FragmentMensajeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initializeBinding(inflater, container)
        initializeEvents()
        return binding.root
    }

    private fun initializeBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentMensajeBinding.inflate(inflater, container, false)
    }


    private fun initializeEvents() {
        binding.btnCifrar.setOnClickListener {
            val texto = binding.editTextTextMultiLine.text.toString()
            val lista = listOf(
                binding.chkCifrado1,
                binding.chkCifrado2,
                binding.chkCifrado3
            )

            val seleccionado = lista
                .filter { it.isChecked }
                .map {lista.indexOf(it)}
                .toIntArray()

            val navController = findNavController()
            val action = MensajeFragmentDirections.actionMensajeFragmentToResultadoFragment(texto, seleccionado)

            navController.navigate(action)
        }
    }
}