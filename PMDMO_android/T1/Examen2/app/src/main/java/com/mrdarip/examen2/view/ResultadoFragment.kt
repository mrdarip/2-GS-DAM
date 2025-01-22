package com.mrdarip.examen2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mrdarip.examen2.entity.AlumnosAdapter
import com.mrdarip.examen2.viewModel.ResultadoViewModel
import com.mrdarip.examen2.databinding.FragmentResultadoBinding

class ResultadoFragment : Fragment() {
    lateinit var binding: FragmentResultadoBinding
    lateinit var viewModel: ResultadoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        initializeBinding()
        initializeViewModel()
        initializeRecyclerView()

        return binding.root
    }

    private fun initializeBinding() {
        binding = FragmentResultadoBinding.inflate(layoutInflater)
    }

    private fun initializeRecyclerView() {
        val asignatura = ResultadoFragmentArgs.fromBundle(requireArguments()).asignatura


        binding.recView.adapter = AlumnosAdapter(alumnos =
        viewModel.getAlumnosOf(asignatura))
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(ResultadoViewModel::class.java)
        viewModel.initializeMatriculados(requireContext())
    }
}