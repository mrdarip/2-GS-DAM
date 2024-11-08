package com.exampi.ej1examen

class Jugador() {

    var victorias = 0
    var puntos: Int? = null

    public fun ganar(){
        victorias++
    }

    public fun haTirado(): Boolean{
        return puntos != null
    }

}