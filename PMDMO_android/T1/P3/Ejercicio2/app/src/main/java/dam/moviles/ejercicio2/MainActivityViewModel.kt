package dam.moviles.ejercicio2

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val startingLifes: Int = 4
    private var lifes = startingLifes

    var guessingNumber = newRandomNumber()

    private fun resetGuessingNumber() {
        guessingNumber = newRandomNumber()
    }

    private fun newRandomNumber() = (1..10).random()

    private fun resetGame() {
        resetGuessingNumber()
        resetLifes()
    }
    fun getLifes(): Int {
        return lifes
    }

    private fun decreaseLifes() {
        lifes--
    }

    private fun resetLifes() {
        lifes = startingLifes
    }

    private fun isGameOver(): Boolean {
        return lifes == 0
    }

    fun guess(attemptedGuess: Int?): GuessType {
        val guessResult = when (attemptedGuess) {
            guessingNumber -> {
                resetGuessingNumber()
                resetLifes()
                GuessType.EQUAL
            }

            in guessingNumber..Int.MAX_VALUE -> {
                decreaseLifes()
                GuessType.GREATER
            }

            in Int.MIN_VALUE..guessingNumber -> {
                decreaseLifes()
                GuessType.LESSER
            }

            else -> GuessType.NAN
        }

        if (isGameOver()) {
            resetGame()

            return GuessType.GAME_OVER
        }else{
            return guessResult
        }
    }
}
