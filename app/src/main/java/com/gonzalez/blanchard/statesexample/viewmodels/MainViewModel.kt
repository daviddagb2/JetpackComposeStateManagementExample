package com.gonzalez.blanchard.statesexample.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val count = mutableStateOf(0)

    fun incrementCount(){
        count.value++
    }

}