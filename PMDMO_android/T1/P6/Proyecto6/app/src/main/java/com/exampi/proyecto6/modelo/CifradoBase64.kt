package com.exampi.proyecto6.modelo

import com.exampi.proyecto6.R

class CifradoBase64 : AlgoritmoCifrado {
    override val nombre: String = "Base64"
    override val icono: Int = R.drawable.base64

    override fun cifrar(mensaje: String): String {
        return android.util.Base64.encodeToString(mensaje.toByteArray(), android.util.Base64.DEFAULT)
    }

}