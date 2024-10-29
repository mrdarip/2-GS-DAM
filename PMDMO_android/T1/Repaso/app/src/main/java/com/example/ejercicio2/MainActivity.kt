package com.example.ejercicio2

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ejercicio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        initializeButton()

        binding.editTextTextMultiLine.text = Editable.Factory.getInstance().newEditable(viewModel.readFile(filesDir))
    }

    private fun initializeButton() {
        binding.button.setOnClickListener {
            writeFile()
        }
    }

    private fun writeFile() {
        val dir = filesDir
        val content = binding.editTextTextMultiLine.text.toString()

        viewModel.writeFile(dir, content)
    }

}