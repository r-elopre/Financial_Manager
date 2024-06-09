package com.example.financialmanager.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.financialmanager.R
import com.example.financialmanager.functions.BankLoanDialog
import com.example.financialmanager.functions.ContentColumn
import com.example.financialmanager.functions.FamilyBox
import com.example.financialmanager.functions.StockCategories
import com.example.financialmanager.viewModel.HomeViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = viewModel()
    val showBankLoanDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        ContentColumn(viewModel, showBankLoanDialog)

        //FamilyBox()

        StockCategories(
            showDialog = remember { mutableStateOf(false) },
            dialogText = remember { mutableStateOf("") },
            alignment = Alignment.BottomCenter, // Pass alignment here
            viewModel = viewModel // Pass the viewModel here
        )
    }

    if (showBankLoanDialog.value) {
        BankLoanDialog(
            onDismiss = { showBankLoanDialog.value = false },
            onConfirm = { amount -> viewModel.addAmount(amount) } // Update both amounts
        )
    }
}
