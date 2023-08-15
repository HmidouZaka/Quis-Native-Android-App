package com.projectbyzakaria.quizapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.projectbyzakaria.quizapp.data.cach.UserCache
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
import com.projectbyzakaria.quizapp.ui.screens.ResultScreen
import com.projectbyzakaria.quizapp.ui.theme.QuizAppTheme
import com.projectbyzakaria.quizapp.ui.viewmodels.QuizViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class QuizActivity : ComponentActivity() {

    val viewModel by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var index = 0
        setContent {
            QuizAppTheme {
                val userCaches = UserCache(this@QuizActivity)
                val coroutine = rememberCoroutineScope { Dispatchers.Main }
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
                    2 -> 5 * 60
                    3 -> 5 * 60
                    4 -> 4 * 60
                    5 -> 4 * 60
                    6 -> 3 * 60
                    7 -> 2 * 60
                    8 -> 2 * 60
                    9 -> 1 * 60
                    10 -> 45
                    else -> 5 * 60
                }
                var isSuccess: Boolean? by rememberSaveable {
                    mutableStateOf(null)
                }

                if (isSuccess == null) {
                    LaunchedEffect(key1 = true) {
                        if (viewModel.isInitial) {
                            viewModel.setTime(timeDown) {
                                isSuccess = false
                            }
                            viewModel.setCurrentQuestion(listOfQuizQuestions.get(index))
                            viewModel.isInitial = false
                        }
                    }
                    val question = viewModel.question
                    question?.let {
                        QuizScreen(
                            question = question,
                            onClickNextQuestion = {
                                if (index < 19) {
                                    ++index
                                    viewModel.setCurrentQuestion(listOfQuizQuestions.get(index))
                                    viewModel.numberOfQuestions = index + 1
                                } else {
                                    viewModel.cancelTimer()
                                    isSuccess = viewModel.paints >= viewModel.targetResult
                                    if (isSuccess == true){
                                        coroutine.launch(Dispatchers.Main) {
                                            if (userLevel == currentLevelClick) {
                                                userCaches.setCurrentUserLevel(currentLevelClick + 1)
                                            }
                                            when (currentLevelClick) {
                                                1 -> userCaches.setPaintsForLevelOne(viewModel.paints)
                                                2 -> userCaches.setPaintsForLevelTwo(viewModel.paints)
                                                3 -> userCaches.setPaintsForLevelTree(viewModel.paints)
                                                4 -> userCaches.setPaintsForLevelFour(viewModel.paints)
                                                5 -> userCaches.setPaintsForLevelFive(viewModel.paints)
                                                6 -> userCaches.setPaintsForLevelSex(viewModel.paints)
                                                7 -> userCaches.setPaintsForLevelSeven(viewModel.paints)
                                                8 -> userCaches.setPaintsForLevelEight(viewModel.paints)
                                                9 -> userCaches.setPaintsForLevelNine(viewModel.paints)
                                                10 -> userCaches.setPaintsForLevelTen(viewModel.paints)
                                                else -> userCaches.setPaintsForLevelOne(viewModel.paints)
                                            }

                                        }
                                    }
                                }

                            },
                            isLastQuestion = (question.id) % 20 == 0,
                            numberOfQuestion = { viewModel.numberOfQuestions },
                            targetPaint = { viewModel.paints },
                            viewModel =
                            viewModel,
                            onSubmit = {
                                if (it) {
                                    ++viewModel.paints
                                }
                            }
                        )
                    }
                } else {

                    ResultScreen(
                        currentLevel = currentLevelClick,
                        nextLevel = if (currentLevelClick == 10) 10 else currentLevelClick + 1,
                        paints = { viewModel.paints },
                        isSuccess = isSuccess == true,
                        isLastPaint = { true },
                        onClickNextLevel = {
                            finish()
                            val quizIntent = Intent(this@QuizActivity, QuizActivity::class.java)
                                .apply {
                                    putExtra("level_click", currentLevelClick + 1)
                                    putExtra("cache_level", currentLevelClick + 1)
                                }
                            startActivity(quizIntent)

                        },
                        onClickTryAgain = {
                            finish()
                            startActivity(Intent(this, QuizActivity::class.java)
                                .apply {
                                    putExtra("level_click", currentLevelClick)
                                    putExtra("cache_level", userLevel)
                                })
                        },
                        onClickBack = {
                            finish()
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }


            }
        }
    }
}