package com.exampi.proyecto6.modelo

import com.exampi.proyecto6.R

class CifradoCesar: CifradoDesplazamiento(1) {
    override val nombre: String = "Cifrado César"
    override val icono: Int = R.drawable.cesar
}