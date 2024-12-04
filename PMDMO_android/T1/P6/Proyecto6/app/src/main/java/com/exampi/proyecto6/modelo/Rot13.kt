package com.exampi.proyecto6.modelo

import com.exampi.proyecto6.R

class Rot13: CifradoDesplazamiento(13) {
    override val nombre: String = "ROT13"
    override val icono: Int = R.drawable.rot13
}