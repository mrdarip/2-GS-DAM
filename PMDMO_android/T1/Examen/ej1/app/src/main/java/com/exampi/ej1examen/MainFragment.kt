package com.exampi.ej1examen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.exampi.ej1examen.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupBinding(inflater, container)
        setupViewModel()

        initializeButton()

        return binding.root
    }

    private fun initializeButton() {
        binding.tirarDadosButton.setOnClickListener{
            val idRadioButtonSeleccionado = binding.radioGroup.checkedRadioButtonId
            if(idRadioButtonSeleccionado == -1){
                Toast.makeText(context, "Selecciona un radioButton", Toast.LENGTH_SHORT).show()
            }else{
                val radioButtonSeleccionado = binding.root.findViewById<RadioButton>(idRadioButtonSeleccionado)
                val indexJugador = getRadioButtonsOrdered().indexOf(radioButtonSeleccionado)

                viewModel.tirarDados()

                getEditTextsOrdered().get(indexJugador).setText("Puntos: ${viewModel.getSumaDados()}")

                radioButtonSeleccionado.isEnabled = false
                binding.radioGroup.clearCheck()
            }

            var jugadoresQueHanTirado = 0
            for (jugador in viewModel.Jugadores){
                if(jugador.haTirado()){
                    jugadoresQueHanTirado++
                }
            }
            if (jugadoresQueHanTirado>=4){
                viewModel.calcularGanador()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        restoreUI()
    }

    private fun restoreUI() {
        //TODO: MOVER A UN SOLO FOREACH
        getEditTextsOrdered().forEachIndexed { index, editText ->
            val jugador = viewModel.Jugadores.get(index)
            val puntos = jugador.puntos?:"sin lanzar"
            editText.setText("Puntos: $puntos")
        }

        getTextViewsOrdered().forEachIndexed { index, textView ->
            val jugador = viewModel.Jugadores.get(index)
            val victorias = jugador.victorias
            textView.setText("Victorias: $victorias")
        }

        getDadoImages().forEachIndexed { index, imageView ->
            val dado = viewModel.valoresDados.get(index)
            imageView.setImageDrawable(context?.getDrawable(dado.drawable))
        }
    }

    private fun getDadoImages(): List<ImageView> {
        return listOf(
            binding.dadoImageL,
            binding.dadoImageR
        )
    }

    private fun getTextViewsOrdered(): List<TextView> {
        return listOf(
            binding.victoriasP1TV,
            binding.victoriasP2TV,
            binding.victoriasP3TV,
            binding.victoriasP4TV
        )

    }

    private fun getEditTextsOrdered(): List<EditText> {
        return listOf(
            binding.PuntosP1ET,
            binding.PuntosP2ET,
            binding.PuntosP3ET,
            binding.PuntosP4ET,
        )
    }

    private fun getRadioButtonsOrdered(): List<RadioButton> {
        return listOf(
            binding.player1Radio,
            binding.player2Radio,
            binding.player3Radio,
            binding.player4Radio
            )
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun setupBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = MainFragmentBinding.inflate(inflater, container, false)
    }
}