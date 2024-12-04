package com.exampi.proyecto6.viewmodel

import androidx.lifecycle.ViewModel
import com.exampi.proyecto6.modelo.AlgoritmoCifrado
import com.exampi.proyecto6.modelo.getAlgoritmo

class ResultadoFragmentViewModel():ViewModel() {
    var mensaje = ""
    var listaCifrados = emptyList<AlgoritmoCifrado>()
    var listaResultados: List<String> = emptyList()

    fun inicializarCifrados(listaNumero : IntArray){
        listaCifrados = listaNumero.map { getAlgoritmo(it) }
    }

    fun cifrarMensaje(mensaje : String) {
        this.mensaje = mensaje
        listaResultados = listaCifrados.map { it.cifrar(mensaje) }
    }
}