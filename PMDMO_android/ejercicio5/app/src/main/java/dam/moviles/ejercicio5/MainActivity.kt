package dam.moviles.ejercicio5

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dam.moviles.ejercicio5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityMainBinding.inflate(layoutInflater)
        //Carga el xml y crea los objetos de la interfaz
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener{
            val to = binding.toTxt.text.toString()
            val message = binding.messageTxt.text.toString()

            val log = "to: $to\nmessage: $message"

            Log.i("ej5output",log)

            val myToast = Toast.makeText(this, log,Toast.LENGTH_LONG)

            myToast.show()
        }
    }
}