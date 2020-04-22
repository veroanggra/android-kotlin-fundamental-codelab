package com.veronica.idn.guesstheword.screen.score

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ScoreViewModel(finalScore : Int) : ViewModel() {
    var score = finalScore

    init {
        Timber.i("Final Score is $finalScore")
    }
}