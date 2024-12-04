package com.exampi.proyecto6.modelo

open abstract class CifradoDesplazamiento(val desplazamiento: Int):AlgoritmoCifrado {
    override fun cifrar(mensaje: String):String =
        mensaje.toCharArray()
            .map{it.code}
            .map{it+desplazamiento}
            .map { it.toChar() }
            .joinToString("")
}