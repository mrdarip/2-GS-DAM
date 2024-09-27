package movil.proyecto2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import movil.proyecto2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityMainBinding.inflate(layoutInflater)
        //Carga el xml y crea los objetos de la interfaz
        setContentView(binding.root)
        this.inicializarEventos()
    }

    fun inicializarEventos(){
        binding.btnSeleccionarCurso.setOnClickListener{
            val curso = binding.spiCurso.selectedItem.toString()
            val asignaturas = this.getAsignaturas(curso)
            binding.txtAsignatura.text = darFormato(asignaturas)
        }

        binding.btnEnviar.setOnClickListener{
            Toast.makeText(
                this,
                "Las observaciones son ${binding.txtObservaciones.text}",
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