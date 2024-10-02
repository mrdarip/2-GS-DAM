package dam.moviles.proyecto3

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.proyecto3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewmodel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeViewModel()
        initializeEvents()
    }

    private fun initializeViewModel() {
        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun initializeEvents() {
        binding.apply {
            btnStart.setOnClickListener { start() }
            btnStop.setOnClickListener { stop() }
            btnPausa.setOnClickListener { pause() }
            btnReiniciar.setOnClickListener { reset(0) }
        }
    }

    private fun reset(offset: Long) {
        base = SystemClock.elapsedRealtime() - offset
        binding.chrClock.base = base
    }

    private fun pause() {
        enableStartBtn(true)
        tiempoTranscurrido = SystemClock.elapsedRealtime() - base

        binding.chrClock.stop()
        situation = Situation.PAUSED
    }

    private fun stop() {
        binding.chrClock.stop()

        reset(0)

        enableStartBtn(true)

        situation=Situation.STOPPED
    }

    private fun start() {
        enableStartBtn(false)

        reset(if(situation == Situation.PAUSED) tiempoTranscurrido else 0)


        binding.chrClock.start()

        situation = Situation.RUNNING
    }


    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun enableStartBtn(b: Boolean) {
        binding.btnStart.isEnabled = b
        binding.btnStop.isEnabled = !b
        binding.btnPausa.isEnabled = !b
        binding.btnReiniciar.isEnabled = !b
    }
}