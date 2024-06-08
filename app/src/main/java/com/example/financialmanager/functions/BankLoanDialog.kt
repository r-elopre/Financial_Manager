package com.example.financialmanager.functions


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BankLoanDialog(onDismiss: () -> Unit) {
    var amount by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("OK")
            }
        },
        text = {
            Column {
                Text("Enter the amount you want to loan:", fontSize = 16.sp)
                TextField(
                    value = amount,
                    onValueChange = { amount = it },
                    modifier = Modifier.padding(top = 8.dp),
                    placeholder = { Text("Enter amount") }
                )
            }
        }
    )
}