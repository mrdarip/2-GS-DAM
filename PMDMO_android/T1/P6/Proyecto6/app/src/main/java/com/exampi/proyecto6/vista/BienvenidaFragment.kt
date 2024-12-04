package com.exampi.proyecto6.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.exampi.proyecto6.R
import com.exampi.proyecto6.databinding.FragmentBienvenidaBinding

class BienvenidaFragment : Fragment() {
    lateinit var binding: FragmentBienvenidaBinding

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
        binding = FragmentBienvenidaBinding.inflate(inflater, container, false)
    }
    private fun initializeEvents() {
        binding.button.setOnClickListener{
            val navigationController = findNavController()

            val action = BienvenidaFragmentDirections.actionBienvenidaFragmentToMensajeFragment()
            navigationController.navigate(action)
        }
    }
}