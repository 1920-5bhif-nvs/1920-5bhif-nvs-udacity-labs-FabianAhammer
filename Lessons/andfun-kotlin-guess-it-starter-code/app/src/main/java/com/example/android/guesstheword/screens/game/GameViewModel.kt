package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){

    // The current word
    private val _word = MutableLiveData<String>()
    val word : LiveData<String>
        get() = _word


    // The current score// internal
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() {
            return _score
        }

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private val _gameFinished = MutableLiveData<Boolean>()
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished


    init {
        Log.i("GameViewModel","GameViewModel created!")
        resetList()
        nextWord()
        _word.value = ""
        _score.value = 0
        _gameFinished.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }


    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
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

    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
           _gameFinished.value = true
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    fun onGameFinishComplete(){
        _gameFinished.value = false
    }
}