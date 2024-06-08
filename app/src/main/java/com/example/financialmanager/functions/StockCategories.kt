package com.example.financialmanager.functions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxScope.StockCategories(
    showDialog: MutableState<Boolean>,
    dialogText: MutableState<String>,
    alignment: Alignment = Alignment.BottomCenter // Accept alignment as a parameter
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .align(alignment) // Apply alignment here
            .padding(bottom = 48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.LightGray)
                    .padding(8.dp)
                    .clickable {
                        dialogText.value = "You clicked Technology stock"
                        showDialog.value = true
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Technology stock",
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Price stock $2",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Gray)
                    .padding(8.dp)
                    .clickable {
                        dialogText.value = "You clicked Economy stock"
                        showDialog.value = true
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Economy stock",
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Price stock $2",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.DarkGray)
                    .padding(8.dp)
                    .clickable {
                        dialogText.value = "You clicked Commercial stock"
                        showDialog.value = true
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Commercial stock",
                    fontSize = 14.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Price stock $2",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Black)
                    .padding(8.dp)
                    .clickable {
                        dialogText.value = "You clicked Financial stock"
                        showDialog.value = true
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Financial stock",
                    fontSize = 14.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Price stock $2",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            confirmButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text("OK")
                }
            },
            text = {
                Text(dialogText.value)
            }
        )
    }
}