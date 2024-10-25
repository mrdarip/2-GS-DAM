package com.example.ejercicio3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ejercicio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initialiazeViewModel()

        binding.floatingActionButton.setOnClickListener {
            val vacios = getEmptyEdTxt()
            var mensaje = if(vacios.isEmpty()){
                "Todos los campos están llenos"
            }else{
                "Campos vacíos: $vacios"
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }

    private fun initialiazeViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getEmptyEdTxt():List<String>{
        /*var inputs = listOf(
            binding.nameEdTxt,
            binding.middleNameEdTxt,
            binding.lastNameEdTxt,
            binding.tfnEdTxt, binding.phoneTagEdTxt,
            binding.emailEdTxt,binding.emailTagEdTxt,
            binding.adressEdTxt, binding.adressTagEdTxt,
            binding.birthdayEdTxt,
            binding.groupEdTxt,
            binding.saveToEdTxt
        )*/

        var inputs = binding.run {
            listOf(
                nameEdTxt,
                middleNameEdTxt,
                lastNameEdTxt,
                tfnEdTxt, phoneTagEdTxt,
                emailEdTxt,emailTagEdTxt,
                adressEdTxt, adressTagEdTxt,
                birthdayEdTxt,
                groupEdTxt,
                saveToEdTxt
            )
        }

        var emptyInputs = mutableListOf<String>()

        for (input in inputs){
            if(input.text.toString().isEmpty()){
                emptyInputs.add(input.hint.toString())
            }
        }

        return emptyInputs
    }
}