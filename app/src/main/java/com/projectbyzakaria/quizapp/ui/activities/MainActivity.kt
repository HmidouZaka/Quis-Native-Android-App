package com.projectbyzakaria.quizapp.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelInitializer
import com.projectbyzakaria.quizapp.data.cach.UserCache
import com.projectbyzakaria.quizapp.ui.components.LoadingComponent
import com.projectbyzakaria.quizapp.ui.screens.HomeScreen
import com.projectbyzakaria.quizapp.ui.theme.QuizAppTheme
import com.projectbyzakaria.quizapp.ui.viewmodels.HomeViewModel
import com.projectbyzakaria.quizapp.utils.ScreenState

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<HomeViewModel>{
        ViewModelProvider.Factory.from(ViewModelInitializer(HomeViewModel::class.java) { HomeViewModel(UserCache(this@MainActivity)) })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {

                val state by viewModel.homeScreenState.collectAsState()

                if (state is ScreenState.Success ){
                    val dataCaches = (state as ScreenState.Success).caches
                    HomeScreen(
                        modifier = Modifier.fillMaxSize(),
                        levelNumber = dataCaches.currentLevel,
                        paints = dataCaches.paints
                    ) {
                        startActivity(Intent(this,QuizActivity::class.java).apply {
                            putExtra("level_click",it)
                            putExtra("cache_level",dataCaches.currentLevel)
                        })
                    }
                }else if (state is ScreenState.Loading){
                    LoadingComponent(Modifier.fillMaxSize())
                }


            }
        }
    }
}
