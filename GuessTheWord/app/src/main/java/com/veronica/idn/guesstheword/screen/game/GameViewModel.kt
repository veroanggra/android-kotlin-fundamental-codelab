package com.veronica.idn.guesstheword.screen.game

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {
    var word = ""
    var score = 0

    private lateinit var wordList: MutableList<String>

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calender",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    init {
        Timber.i("GameViewModel created !")
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed!")
    }

    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    private fun nextWord() {
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }
    }
}