package dam.moviles.proyecto4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import dam.moviles.proyecto4.databinding.FragmentFormularioBinding

class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupBinding(inflater, container)
        setupTaskBar()

        setupButtons()
        setupFloatingButton()

        return binding.root
    }

    private fun setupTaskBar() {
        val mainActivity = activity as MainActivity
        mainActivity.setSupportActionBar(binding.materialToolbar)
    }

    private fun setupBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentFormularioBinding.inflate(inflater, container, false)
    }

    private fun deactiveButtons() {
        getButtonsList().forEach {
            it.alpha = 0.6f
        }
    }

    private fun setupFloatingButton(){
        binding.btnEnviar.setOnClickListener{
            if(binding.checkBox.isChecked){
                val idBotonSeleccionado = binding.grupoBotones.checkedRadioButtonId

                if(idBotonSeleccionado != -1){
                    val radioButtonSeleccionado = binding.root.findViewById<RadioButton>(idBotonSeleccionado)
                    Toast.makeText(requireContext(), radioButtonSeleccionado.text, Toast.LENGTH_SHORT).show()

                }
                else{
                    Snackbar.make(binding.btnEnviar, "Debes seleccionar una opción", Snackbar.LENGTH_SHORT).show()
                }
            }
            else{
                Snackbar.make(binding.btnEnviar, "Debes aceptar los términos y condiciones", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
    private fun setupButtons() {
        getButtonsList().forEach {
            it.setOnClickListener {
                deactiveButtons()
                it.alpha = 1f
            }
        }
    }
    private fun getButtonsList(): List<ImageView> = listOf(
        binding.imageView,
        binding.imageView2,
        binding.imageView3,
        binding.imageView4,
        binding.imageView5,
    )
}