package com.example.financialmanager.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class HomeViewModel : ViewModel() {
    private val _coinAmount = mutableStateOf(100) // Initialize with 100
    val coinAmount: State<Int> = _coinAmount

    private val _bankAmount = mutableStateOf(0) // Initialize with 0
    val bankAmount: State<Int> = _bankAmount

    fun addAmount(newAmount: Int) {
        _coinAmount.value += newAmount
        _bankAmount.value = newAmount
    }
}