package com.example.calculatorviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var result = 0

    fun calculate(width: String, lenght: String, height: String){
        result = width.toInt() * lenght.toInt() * height.toInt()
    }
}