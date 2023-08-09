package com.projectbyzakaria.quizapp.utils

import com.projectbyzakaria.quizapp.model.UserCache

sealed class ScreenState {
    object Loading : ScreenState()
    data class Success(val caches : UserCache) : ScreenState()
}