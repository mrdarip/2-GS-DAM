package dam.moviles.proyecto3

import android.os.SystemClock
import android.widget.Chronometer
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var situation = Situation.STOPPED
    var base = SystemClock.elapsedRealtime()
    var elapsedTime = 0L

    fun reset(offset: Long, clock: Chronometer) {
        base = SystemClock.elapsedRealtime() - offset
        clock.base = base
    }

    fun updateElapsedTime() {
        elapsedTime = SystemClock.elapsedRealtime() - base
    }
}