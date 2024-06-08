package com.example.financialmanager.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class HomeViewModel : ViewModel() {
    private val _coinAmount = mutableStateOf(100) // Initialize with 100
    val coinAmount: State<Int> = _coinAmount

    private val _bankAmount = mutableStateOf(0) // Initialize with 0
    val bankAmount: State<Int> = _bankAmount

    private val _requiredClicks = mutableStateOf(0)
    val requiredClicks: State<Int> = _requiredClicks

    private val _currentClicks = mutableStateOf(0)
    val currentClicks: State<Int> = _currentClicks

    init {
        generateRequiredClicks()
    }

    fun addAmount(newAmount: Int) {
        _coinAmount.value += newAmount
        _bankAmount.value = newAmount
    }

    fun generateRequiredClicks() {
        _requiredClicks.value = (10..20).random()
        _currentClicks.value = 0
    }

    fun incrementClicks() {
        _currentClicks.value += 1
        if (_currentClicks.value >= _requiredClicks.value) {
            _coinAmount.value += 50
            generateRequiredClicks()
        }
    }
}
