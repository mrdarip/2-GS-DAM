package dam.moviles.proyecto3

import android.os.SystemClock

class MainActivityViewModel {
    var situation = Situation.STOPPED
    var base = SystemClock.elapsedRealtime()

    var tiempoTranscurrido = 0L
}