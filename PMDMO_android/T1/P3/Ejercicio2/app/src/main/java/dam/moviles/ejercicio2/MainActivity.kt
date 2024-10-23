package dam.moviles.ejercicio2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ejercicio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeViewModel()


        updateLifes()
        binding.guessBtn.setOnClickListener {
            val guess = binding.numGuessET.text.toString().toIntOrNull()

            val message = when (viewModel.guess(guess)) {
                GuessType.EQUAL -> "Has ganado"
                GuessType.GREATER -> "Tu número es mayor"
                GuessType.LESSER -> "Tu número es menor"
                GuessType.GAME_OVER -> "Has perdido, el numero era ${viewModel.getGuessingNumber()}"
                GuessType.NAN -> "Introduce un numero correcto"
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            updateLifes()
        }
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    fun updateLifes() {
        binding.lifesTF.text = getString(R.string.lifes, viewModel.getLifes())
    }
}