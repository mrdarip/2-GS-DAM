package dam.moviles.ejercicio1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ejercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViewModel()
        setBinding()

        setColor()
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun setBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setColor() {
        binding.main.setBackgroundColor(getColor(viewModel.getBackgroundColorResource()))
        binding.text.text = getString(viewModel.getColorName())
    }
}