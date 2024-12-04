package com.exampi.proyecto6.vista

import androidx.recyclerview.widget.RecyclerView
import com.exampi.proyecto6.databinding.FragmentCifradoBinding
import com.exampi.proyecto6.modelo.AlgoritmoCifrado

class CifradoHolder(val binding:FragmentCifradoBinding) : RecyclerView.ViewHolder(binding.root) {

    var cifrado = ""
    var mensaje = ""

    fun mostrarCifrado(c: AlgoritmoCifrado, m: String){
        cifrado = c.nombre
        mensaje = m

        binding.textView3.text = c.nombre
        binding.textView4.text = m
        binding.imageView.setImageResource(c.icono)
    }
}