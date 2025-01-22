package com.mrdarip.examen2.view

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.mrdarip.examen2.databinding.FragmentAlumnoHolderBinding
import com.mrdarip.examen2.entity.Alumno

class AlumnoHolder(val binding: FragmentAlumnoHolderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun getAlumno(a: Alumno){
        binding.nameTXT.text = a.nombre
        binding.surnameTXT.text = a.apellidos
        binding.lessonsTXT.text = a.asignaturas.joinToString(", ")

        binding.root.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, a.nombre)
                type = "text/plain"
            }

            binding.root.context.startActivity(sendIntent)
        }
    }
}