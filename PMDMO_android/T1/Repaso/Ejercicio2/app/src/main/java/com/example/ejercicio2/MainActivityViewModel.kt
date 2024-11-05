package com.example.ejercicio2

import android.util.Log
import androidx.lifecycle.ViewModel
import java.io.File
import java.io.FileWriter

class MainActivityViewModel : ViewModel() {
    fun readFile(dir:File):String{
        val file = File(dir, "data.txt")

        if (!file.exists()){
            Log.d("MainActivityViewModel", "File does not exist")
            return ""
        }

        val content = file.readText()
        Log.d("MainActivityViewModel", "Content: $content")
        return content
    }

    fun writeFile(dir:File, content:String){
        val file = File(dir, "data.txt")
        Log.d("MainActivityViewModel", "Writing content: $content")

        val pw = FileWriter(file, false)

        pw.write(content)
        Log.d("MainActivityViewModel", "Content written")
        pw.close()
    }
}
