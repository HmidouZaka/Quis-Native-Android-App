package com.projectbyzakaria.quizapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectbyzakaria.quizapp.data.cach.Caches
import com.projectbyzakaria.quizapp.utils.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val caches:Caches
) : ViewModel() {

    private val _homeScreenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val homeScreenState = _homeScreenState.asStateFlow()



    private fun loadData(){
        viewModelScope.launch {
            val userCachesFlow = caches.getCurrentUserLevel()
            userCachesFlow.collectLatest {
                _homeScreenState.emit(ScreenState.Success(it))
            }
        }
    }
    init {
        loadData()
    }
}