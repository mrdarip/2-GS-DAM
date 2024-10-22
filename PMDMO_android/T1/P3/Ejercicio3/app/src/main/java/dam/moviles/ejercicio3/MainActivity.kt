package dam.moviles.ejercicio3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ejercicio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initializeBinding()
        initializeViewModel()

        binding.StartButton.setOnClickListener {
            val inputTime = binding.secondsInput.text.toString().toLongOrNull()

            if(inputTime != null) {
                startChrono(inputTime)
            }
        }
    }

    private fun startChrono(seconds: Long) {
        
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}