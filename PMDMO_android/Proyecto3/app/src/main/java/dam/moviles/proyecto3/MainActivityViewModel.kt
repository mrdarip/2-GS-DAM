package dam.moviles.proyecto3

import android.os.SystemClock
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var situation = Situation.STOPPED
    var base = SystemClock.elapsedRealtime()
    var tiempoTranscurrido = 0L
}