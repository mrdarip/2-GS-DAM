package com.mrdarip.examen2.entity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrdarip.examen2.databinding.FragmentAlumnoHolderBinding
import com.mrdarip.examen2.view.AlumnoHolder

class AlumnosAdapter(
    val alumnos: List<Alumno>
) : RecyclerView.Adapter<AlumnoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoHolder {
            val binding =
                FragmentAlumnoHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return AlumnoHolder(binding)
        }

    override fun onBindViewHolder(holder: AlumnoHolder, position: Int) {
        holder.getAlumno(alumnos.get(position))
    }

    override fun getItemCount(): Int = alumnos.size
}