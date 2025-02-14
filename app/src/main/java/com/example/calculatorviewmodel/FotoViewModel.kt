package com.example.calculatorviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FotoViewModel: ViewModel() {
    val listPoto = MutableLiveData<MutableList<foto>>()

    init {
        listPoto.value = mutableListOf()
    }
}