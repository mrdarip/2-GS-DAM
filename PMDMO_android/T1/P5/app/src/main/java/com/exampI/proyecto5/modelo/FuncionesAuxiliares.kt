package com.exampI.proyecto5.modelo

import android.content.Context
import com.exampI.proyecto5.R
import com.squareup.moshi.Moshi
import java.io.BufferedReader
import java.io.InputStream

/*
Context es un objeto que representa la app que estamos programando.
Aquí es necesario porque nos da acceso a la carpeta res, que es donde está el archivo datos.json


¿Cómo conseguirmos un context?
Cuando estamos en MainActivity, MainActivity es el context (this)
Cuando estamos en un Fragment, el context se obtiene llamando al método requireContext()
*/

fun cargarDatosJson(context: Context):String{
    val carpetaRes = context.resources
    val archivo: InputStream = carpetaRes.openRawResource(R.raw.datos)
    val bufferedReader:BufferedReader = archivo.bufferedReader()
    val texto:String = bufferedReader.readText()
    return texto
}

fun convertirJsonEnTienda(json:String): Tienda {
    val moshi: Moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Tienda::class.java)
    val tienda: Tienda? = adapter.fromJson(json)
    return checkNotNull(tienda) {"No se ha cargado bien el datos.json"}
}