package com.exampi.ej1examen

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var Jugadores = listOf(Jugador(),Jugador(),Jugador(),Jugador())

    var valoresDados = listOf(Dado.LOGO, Dado.LOGO)

    public fun tirarDados(){
        valoresDados = listOf(tirarDado(), tirarDado())
    }
    public fun getSumaDados(): Int{
        val valorDado1 = valoresDados.get(0).valor
        val valorDado2 = valoresDados.get(1).valor

        if (valorDado1 != null && valorDado2 != null) {
            return (valorDado1 + valorDado2)
        }else{
            return -1
        }
    }
    private fun tirarDado(): Dado {
        return Dado.entries.get((1..6).random())
    }

    fun calcularGanador() {
        var indexMejorJugador = -1
        var puntuacionMejor = -1

        //me quedo sin tiempo....
    }
}