package com.mrdarip.examen2.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Alumno (
    val nombre:String,
    val apellidos:String,
    @Json(name = "lista_de_asignaturas_matriculadas") val asignaturas:List<String>
)