package com.example.myviewmodelexample

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel()
{
    var counter = mutableStateOf(1)
}