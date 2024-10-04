package dam.moviles.proyecto3

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
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

    override fun onStart() {
        super.onStart()

        when(viewmodel.situation){
            Situation.STOPPED -> {}
            Situation.RUNNING ->{
                enableStartBtn(false)
                binding.chrClock.base=viewmodel.base
                binding.chrClock.start()
            }
            Situation.PAUSED ->{
                enableStartBtn(true)
                viewmodel.reset(binding.chrClock.base,binding.chrClock)

            }
        }
    }

    private fun initializeViewModel() {
        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun initializeEvents() {
        binding.apply {
            btnStart.setOnClickListener { start() }
            btnStop.setOnClickListener { stop() }
            btnPausa.setOnClickListener { pause() }
            btnReiniciar.setOnClickListener { viewmodel.reset(0,binding.chrClock) }
        }
    }

    private fun pause() {
        enableStartBtn(true)
        viewmodel.updateElapsedTime()

        binding.chrClock.stop()
        viewmodel.situation = Situation.PAUSED
    }

    private fun stop() {
        binding.chrClock.stop()

        viewmodel.reset(0,binding.chrClock)

        enableStartBtn(true)

        viewmodel.situation=Situation.STOPPED
    }

    private fun start() {
        enableStartBtn(false)

        viewmodel.reset(
            if(viewmodel.situation == Situation.PAUSED)
                viewmodel.elapsedTime
            else 0,
            binding.chrClock)

        binding.chrClock.start()

        viewmodel.situation = Situation.RUNNING
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