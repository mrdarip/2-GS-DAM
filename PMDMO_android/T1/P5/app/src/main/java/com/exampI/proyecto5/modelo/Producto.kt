package com.exampI.proyecto5.modelo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Producto(
    val id:Int,
    val nombre:String,
    val precio:Double,
    @Json(name="disponible") val disponibilidad:Boolean,
    @Json(name="detalles") val informacion: Detalle
)
