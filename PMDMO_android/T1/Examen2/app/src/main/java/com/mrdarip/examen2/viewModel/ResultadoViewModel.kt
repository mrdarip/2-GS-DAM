package com.mrdarip.examen2.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mrdarip.examen2.entity.Alumno
import com.mrdarip.examen2.entity.Matriculados
import java.util.Locale

class ResultadoViewModel : ViewModel() {
    lateinit var matriculados: Matriculados

    fun initializeMatriculados(context: Context) {
        matriculados = Matriculados.cargarDatos(context)
    }

    fun getAlumnosOf(asignatura: String?): List<Alumno> {
        val alumnnos: List<Alumno>

        if (asignatura != null) {
            val a = asignatura.lowercase(Locale.ROOT)

            alumnnos = matriculados.alumnos.filter { alumno: Alumno ->
                alumno.asignaturas.map {
                    it.lowercase(Locale.ROOT)
                }.contains(
                    a
                )
            }
        } else {
            alumnnos = matriculados.alumnos
        }

        return alumnnos
    }
}