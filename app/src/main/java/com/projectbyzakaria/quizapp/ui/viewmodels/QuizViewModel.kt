package com.projectbyzakaria.quizapp.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectbyzakaria.quizapp.model.QuizQuestion
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizViewModel  : ViewModel(){


    var targetResult = 10

    var isInitial = true
    var question :QuizQuestion? by mutableStateOf(null)
        private set

    var numberOfQuestions :Int by mutableStateOf(1)

    var paints :Int by mutableStateOf(0)


    fun setCurrentQuestion(question:QuizQuestion){
        this.question = question
    }
    var timer by mutableStateOf(0)
        private  set

    fun setTime(time:Int){
        timer = time
        viewModelScope.launch {
            while (true){
                delay(1000)
                --timer
                if (timer <= 0){
                    break
                }
            }
        }
    }
}