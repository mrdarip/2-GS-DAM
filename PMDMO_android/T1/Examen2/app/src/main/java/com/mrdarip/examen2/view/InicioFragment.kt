package com.mrdarip.examen2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mrdarip.examen2.viewModel.InicioViewModel
import com.mrdarip.examen2.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {

    lateinit var viewModel: InicioViewModel
    lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        initializeViewModel()
        initializeBinding(inflater, container)
        initializeButtons()

        return binding.root
    }

    private fun initializeButtons() {
        val nav = findNavController()

        binding.btnTodo.setOnClickListener {
            val action = InicioFragmentDirections.actionInicioFragmentToResultadoFragment(null)
            nav.navigate(action)
        }

        binding.btnAsignatura.setOnClickListener {
            viewModel.setSelected(binding.ETAsignatura.text.toString())
            val action =
                InicioFragmentDirections.actionInicioFragmentToResultadoFragment(viewModel.getSelected())
            nav.navigate(action)
        }
    }

    private fun initializeBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(InicioViewModel::class.java)
    }
}