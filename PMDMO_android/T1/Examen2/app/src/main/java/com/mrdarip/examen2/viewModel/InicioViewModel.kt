package com.mrdarip.examen2.viewModel

import androidx.lifecycle.ViewModel

class InicioViewModel : ViewModel() {
    var asignatura: String? = null

    fun setSelected(asignatura: String) {
        this.asignatura = asignatura.ifBlank { null }
    }

    fun getSelected(): String? {
        return asignatura
    }
}