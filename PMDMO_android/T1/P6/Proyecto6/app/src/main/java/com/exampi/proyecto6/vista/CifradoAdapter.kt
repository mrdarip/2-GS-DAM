package com.exampi.proyecto6.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exampi.proyecto6.databinding.FragmentCifradoBinding
import com.exampi.proyecto6.modelo.AlgoritmoCifrado

class CifradoAdapter(
    val listaCifrados: List<AlgoritmoCifrado>, val listaResultados: List<String>,
    val lambda: (CifradoHolder) -> Unit
) : RecyclerView.Adapter<CifradoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CifradoHolder {
        val binding =
            FragmentCifradoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CifradoHolder(binding)
    }

    override fun getItemCount(): Int = listaCifrados.size

    override fun onBindViewHolder(holder: CifradoHolder, position: Int) {
        holder.mostrarCifrado(listaCifrados[position], listaResultados[position])
        holder.binding.root.setOnClickListener() {
            lambda(holder)
        }
    }

}

