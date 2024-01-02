package com.example.exm6.presentation.secure_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exm6.R
import com.example.exm6.data.NumFieldValue
import com.example.exm6.data.NumFieldValue.Companion.numFieldList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SecurityScreenViewModel : ViewModel() {

    private val _typedPinCode = MutableSharedFlow<List<NumFieldValue>>()
    val typedPinCode = _typedPinCode.asSharedFlow()

    init {
        viewModelScope.launch {
            _typedPinCode.emit(
                numFieldList
            )
        }
    }

    fun onEvent() {

    }

    fun addDigit(index: Int) {
        viewModelScope.launch {
            _typedPinCode.emit(
                numFieldList.apply {
                    get(index).color = R.color.green
                }
            )
        }
    }


    fun removeDigit(index: Int) {
        viewModelScope.launch {
            _typedPinCode.emit(
                numFieldList.apply {
                    get(index).color = R.color.gray
                }
            )
        }
    }
}