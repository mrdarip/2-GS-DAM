package dam.moviles.ejercicio6

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dam.moviles.ejercicio6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityMainBinding.inflate(layoutInflater)
        //Carga el xml y crea los objetos de la interfaz
        setContentView(binding.root)

        val buttons = listOf(
            binding.byeBtn,
            binding.hiBtn
        )

        buttons.forEach {btn ->
            btn.setOnClickListener{
                Toast.makeText(
                    this,
                    btn.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}