package com.example.exm6.presentation.secure_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SecurityScreenViewModel : ViewModel() {

    private val _typedPinCode = MutableStateFlow(listOf<Int>())
    val typedPinCode = _typedPinCode.asStateFlow()

    fun onEvent() {

    }

}