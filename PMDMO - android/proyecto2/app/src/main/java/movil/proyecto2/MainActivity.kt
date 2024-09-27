package movil.proyecto2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var spiCurso:Spinner
    private lateinit var btnSeleccionarCurso: Button
    private lateinit var txtAsignatura: TextView
    private lateinit var txtObservaciones: EditText
    private lateinit var btnEnviar: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //Carga el xml y crea los objetos de la interfaz
        setContentView(R.layout.activity_main)
        this.inicializarControles()
        this.inicializarEventos()
    }
    fun inicializarControles(){
        spiCurso = findViewById(R.id.spiCurso)
        btnSeleccionarCurso = findViewById(R.id.btnSeleccionarCurso)
        txtAsignatura = findViewById(R.id.txtAsignatura)
        txtObservaciones = findViewById(R.id.txtObservaciones)
        btnEnviar = findViewById(R.id.btnEnviar)
    }

    fun inicializarEventos(){
        btnSeleccionarCurso.setOnClickListener{
            val curso = spiCurso.selectedItem.toString()
            val asignaturas = this.getAsignaturas(curso)
            txtAsignatura.text = darFormato(asignaturas)
        }

        btnEnviar.setOnClickListener{
            Toast.makeText(
                this,
                "Las observaciones son ${txtObservaciones.text}",
                Toast.LENGTH_LONG
            ).show()
        }

    }
    
    fun darFormato(lista:List<String>):String{
        return lista
            .map{ asignatura -> "- ${asignatura}\n"}
            .joinToString("")
    }

    /*fun getAsignaturas(curso:String):List<String>{
        var lista:List<String> = mutableListOf()
        if (curso.equals("1º DAM")){
            lista = listOf("Programación", "Sistemas","Base de datos", "Entornos", "Marcas")
        }else if (curso.equals("2º DAM")){
            lista = listOf("Móviles", "Interfaces","Acceso a datos","Servicios","Sistemas Gestión Empresarial")
        }
        return lista
    }*/

    /*
    fun getAsignaturas(curso:String):List<String>{
        return if (curso.equals("1º DAM")){
            listOf("Programación", "Sistemas","Base de datos", "Entornos", "Marcas")
        }else{
            listOf("Móviles", "Interfaces","Acceso a datos","Servicios","Sistemas Gestión Empresarial")
        }

    }
     */

    /*
    fun getAsignaturas(curso:String):List<String> =
        if (curso.equals("1º DAM")){
            listOf("Programación", "Sistemas","Base de datos", "Entornos", "Marcas")
        }else{
            listOf("Móviles", "Interfaces","Acceso a datos","Servicios","Sistemas Gestión Empresarial")
        }
    }
     */

    fun getAsignaturas(curso:String):List<String> =
        when(curso){
            "1º DAM" -> listOf("Programación", "Sistemas","Base de datos", "Entornos", "Marcas")
            "2º DAM" -> listOf("Móviles", "Interfaces","Acceso a datos","Servicios","Sistemas Gestión Empresarial")
            else -> throw Exception("Curso no admitido")
        }


}