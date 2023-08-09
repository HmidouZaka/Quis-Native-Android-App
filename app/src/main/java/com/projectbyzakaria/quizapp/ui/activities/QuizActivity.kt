package com.projectbyzakaria.quizapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.projectbyzakaria.quizapp.ui.theme.QuizAppTheme

class QuizActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                val currentLevelClick = intent.getIntExtra("level_click",1)
                val userLevel = intent.getIntExtra("cache_level",1)

            }
        }
    }
}