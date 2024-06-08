package com.example.financialmanager.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financialmanager.R
import com.example.financialmanager.viewModel.HomeViewModel

@Composable
fun ContentColumn(viewModel: HomeViewModel, showBankLoanDialog: MutableState<Boolean>) {
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
                    text = "$${viewModel.coinAmount.value}", // Use coinAmount here
                    fontSize = 15.sp,
                    color = Color.Black,
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bank),
                    contentDescription = "Bank",
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { showBankLoanDialog.value = true } // Show Bank Loan Dialog on click
                )

                Text(
                    text = "$${viewModel.bankAmount.value}", // Use bankAmount here
                    fontSize = 15.sp,
                    color = Color.Black,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.work),
                    contentDescription = "Work",
                    modifier = Modifier
                        .size(80.dp)
                )
            }
        }
    }
}