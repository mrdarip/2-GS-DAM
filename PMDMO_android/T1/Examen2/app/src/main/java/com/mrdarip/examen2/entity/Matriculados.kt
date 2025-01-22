package com.mrdarip.examen2.entity

import android.content.Context
import com.mrdarip.examen2.R
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import java.io.BufferedReader
import java.io.InputStream

@JsonClass(generateAdapter = true)
data class Matriculados(
    val alumnos: List<Alumno>
) {
    companion object {
        fun cargarDatos(context: Context): Matriculados =
            Json2Matriculados(json(context))


        fun json(context: Context): String {
            val carpetaRes = context.resources
            val archivo: InputStream = carpetaRes.openRawResource(R.raw.data)
            val bufferedReader: BufferedReader = archivo.bufferedReader()
            val json: String = bufferedReader.readText()
            return json
        }

        fun Json2Matriculados(json: String): Matriculados {
            val moshi: Moshi = Moshi.Builder().build()
            val adapter = moshi.adapter(Matriculados::class.java)
            val matriculados: Matriculados? = adapter.fromJson(json)
            return checkNotNull(matriculados) { "No se pudo cargar el json" }
        }
    }
}
