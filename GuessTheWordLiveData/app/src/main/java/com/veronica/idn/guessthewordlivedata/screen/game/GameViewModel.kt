package com.veronica.idn.guessthewordlivedata.screen.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val _word = MutableLiveData<String>()
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score
    val word: LiveData<String>
        get() = _word

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    private lateinit var wordList: MutableList<String>

    private fun resetList() {
        wordList = mutableListOf(
            "banana",
            "orange",
            "snail",
            "tree",
            "car",
            "motor",
            "bag",
            "roll",
            "crow",
            "trade",
            "strawberry",
            "roll",
            "way",
            "love",
            "cake",
            "fish",
            "soup",
            "home"

        )
        wordList.shuffle()
    }

    init {
        _word.value = ""
        _score.value = 0
        Log.i("GameViewModel", "GameiewModel created!")
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    fun onSkip(){
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }
    fun onCorrect(){
        _score.value=(_score.value)?.plus(1)
    }

    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    private fun onGameFinish() {
        _eventGameFinish.value = true
    }

    fun onGameFinishedComplete() {
        _eventGameFinish.value = false
    }
}