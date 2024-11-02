package dam.moviles.ejercicio1

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val colors = mapOf(
        R.string.red to R.color.red,
        R.string.blue to R.color.blue,
        R.string.green to R.color.green,
        R.string.yellow to R.color.yellow,
        R.string.orange to R.color.orange,
        R.string.black to R.color.black
    )

    private val randomColor = colors.entries.random()
    fun getBackgroundColorResource() = randomColor.value
    fun getColorName() = randomColor.key
}