package com.example.financialmanager.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financialmanager.R
import com.example.financialmanager.functions.BankLoanDialog
import com.example.financialmanager.functions.FamilyBox
import com.example.financialmanager.functions.StockCategories

@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var dialogText by remember { mutableStateOf("") }
    var showBankLoanDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start // Aligns content to the start (left) horizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 100.dp, start = 5.dp) // Use start padding to keep it aligned to the left
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.coin),
                        contentDescription = "Coin",
                        modifier = Modifier
                            .size(80.dp)
                    )

                    Text(
                        text = "$100",
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Image(
                    painter = painterResource(id = R.drawable.bank),
                    contentDescription = "Bank",
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { showBankLoanDialog = true } // Show Bank Loan Dialog on click
                )

                Spacer(modifier = Modifier.height(2.dp))

                Image(
                    painter = painterResource(id = R.drawable.work),
                    contentDescription = "Work",
                    modifier = Modifier
                        .size(80.dp)
                )
            }
        }

        FamilyBox() // Use the new FamilyBox composable here

        // Ensure this is within a Box scope
        StockCategories(
            showDialog = remember { mutableStateOf(showDialog) },
            dialogText = remember { mutableStateOf(dialogText) },
            alignment = Alignment.BottomCenter // Pass alignment here
        )
    }

    if (showBankLoanDialog) {
        BankLoanDialog(onDismiss = { showBankLoanDialog = false })
    }
}