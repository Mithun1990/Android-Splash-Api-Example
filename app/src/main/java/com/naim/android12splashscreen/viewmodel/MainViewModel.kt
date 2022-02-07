package com.naim.android12splashscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _isKeepScreen = MutableStateFlow(true)
    val isKeepScreen = _isKeepScreen.asStateFlow()

    fun isKeepScreen(value: Boolean) {
        _isKeepScreen.value =
            value // After the background data fetch is done make splash screen on false
    }

    init {
        viewModelScope.launch { //Done any back ground task and return it to activtiy
            delay(10000)
            _isKeepScreen.value = false
        }
    }
}