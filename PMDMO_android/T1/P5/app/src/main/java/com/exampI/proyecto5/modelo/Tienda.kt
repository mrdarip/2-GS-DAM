package com.exampI.proyecto5.modelo

import android.content.Context
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass (generateAdapter = true)
data class Tienda(
    @Json(name="productos") val stock: List<Producto>
){
    //los métodos del objeto compañero son los método estáticos de la clase Tienda
    companion object {
        fun cargarDatos(context: Context): Tienda =
            convertirJsonEnTienda(cargarDatosJson(context))
    }
}
