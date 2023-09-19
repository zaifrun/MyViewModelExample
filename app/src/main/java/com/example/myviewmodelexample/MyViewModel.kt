package com.example.myviewmodelexample

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel()
{
    var counter = mutableStateOf(1)


    override fun onCleared() {
        super.onCleared()
        Log.d("MyViewModel","MyViewModel - cleared")
        Log.d("MyViewModel","Time to persist data: counter = $counter")
    }

}