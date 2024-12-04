package com.exampi.proyecto6.modelo

interface AlgoritmoCifrado {
    val nombre: String
    val icono:Int
    fun cifrar(mensaje: String): String
}

fun getAlgoritmo(numero:Int):AlgoritmoCifrado{
    return when(numero){
        0 -> CifradoCesar()
        1 -> Rot13()
        2 -> CifradoBase64()
        else -> throw IllegalArgumentException("Número de algoritmo no válido")
    }
}