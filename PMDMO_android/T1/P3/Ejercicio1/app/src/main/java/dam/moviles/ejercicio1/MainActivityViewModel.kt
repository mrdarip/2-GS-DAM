package dam.moviles.ejercicio1

import android.graphics.Color
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val colors = mapOf(
        R.string.red to Color.RED,
        R.string.blue to Color.BLUE,
        R.string.green to Color.GREEN,
        R.string.yellow to Color.YELLOW,
        R.string.orange to Color.rgb(255, 165, 0),
        R.string.black to Color.BLACK
    )

    private val randomColor = colors.entries.random()

    fun getBackgroundColor() = randomColor.value
    fun getColorName() = randomColor.key
}