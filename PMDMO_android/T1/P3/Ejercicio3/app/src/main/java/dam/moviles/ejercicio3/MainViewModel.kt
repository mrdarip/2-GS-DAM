package dam.moviles.ejercicio3

import android.os.SystemClock
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var base = SystemClock.elapsedRealtime()
}
