package com.projectbyzakaria.quizapp.model

data class QuizQuestion(
    val id : Int,
    val questions : String,
    val correctAnswerIndex:Int,
    val suggestion:List<String>,
    val isMultipleCorrectAnswer:Boolean
)