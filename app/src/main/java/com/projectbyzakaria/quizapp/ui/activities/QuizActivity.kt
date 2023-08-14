package com.projectbyzakaria.quizapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.projectbyzakaria.quizapp.data.levels.LevelEight
import com.projectbyzakaria.quizapp.data.levels.LevelFive
import com.projectbyzakaria.quizapp.data.levels.LevelFour
import com.projectbyzakaria.quizapp.data.levels.LevelNine
import com.projectbyzakaria.quizapp.data.levels.LevelOne
import com.projectbyzakaria.quizapp.data.levels.LevelSeven
import com.projectbyzakaria.quizapp.data.levels.LevelSix
import com.projectbyzakaria.quizapp.data.levels.LevelTen
import com.projectbyzakaria.quizapp.data.levels.LevelTree
import com.projectbyzakaria.quizapp.data.levels.LevelTwo
import com.projectbyzakaria.quizapp.ui.screens.QuizScreen
import com.projectbyzakaria.quizapp.ui.theme.QuizAppTheme
import com.projectbyzakaria.quizapp.ui.viewmodels.QuizViewModel

class QuizActivity : ComponentActivity() {

    val viewModel by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var index = 0
        setContent {
            QuizAppTheme {


                val currentLevelClick = intent.getIntExtra("level_click", 1)
                val userLevel = intent.getIntExtra("cache_level", 1)
                val listOfQuizQuestions = when (currentLevelClick) {
                    1 -> LevelOne.getLevelOneQuestions()
                    2 -> LevelTwo.getLevelTwoQuestions()
                    3 -> LevelTree.getLevelTreeQuestions()
                    4 -> LevelFour.getLevelFourQuestions()
                    5 -> LevelFive.getLevelFiveQuestions()
                    6 -> LevelSix.getLevelSixQuestions()
                    7 -> LevelSeven.getLevelSevenQuestions()
                    8 -> LevelEight.getLevelEightQuestions()
                    9 -> LevelNine.getLevelNineQuestions()
                    10 -> LevelTen.getLevelTenQuestions()
                    else -> LevelOne.getLevelOneQuestions()
                }

                val timeDown = when (currentLevelClick) {
                    1 -> 5 * 60
                    2 ->  5 * 60
                    3 ->  5 * 60
                    4 ->  4 * 60
                    5 ->4 * 60
                    6 -> 3 * 60
                    7 -> 2 * 60
                    8 -> 2 * 60
                    9 -> 1 * 60
                    10 -> 45
                    else -> 5 * 60
                }

                LaunchedEffect(key1 = true ){
                    if (viewModel.isInitial){
                        viewModel.setTime(timeDown)
                        viewModel.setCurrentQuestion(listOfQuizQuestions.get(index))
                        viewModel.isInitial = false
                    }
                }
                val question = viewModel.question
                question?.let {
                    QuizScreen(
                        question = question,
                        onClickNextQuestion = {
                            ++index
                            viewModel.setCurrentQuestion(listOfQuizQuestions.get(index))
                            viewModel.numberOfQuestions = index +1
                        },
                        isLastQuestion = (question.id) % 20 == 0,
                        numberOfQuestion = { viewModel.numberOfQuestions },
                        targetPaint = {viewModel.paints},
                        timer = {
                            viewModel.timer
                                },
                        onSubmit = {
                            if (it){
                                ++viewModel.paints
                            }
                        }
                    )
                }

            }
        }
    }
}