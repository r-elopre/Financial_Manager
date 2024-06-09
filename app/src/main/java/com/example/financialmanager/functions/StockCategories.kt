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
import com.example.financialmanager.viewModel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.material3.ButtonDefaults

@Composable
fun BoxScope.StockCategories(
    showDialog: MutableState<Boolean>,
    dialogText: MutableState<String>,
    alignment: Alignment = Alignment.BottomCenter, // Accept alignment as a parameter
    viewModel: HomeViewModel // Add viewModel as a parameter
) {
    val techStockCount = remember { mutableStateOf(0) }
    val economyStockCount = remember { mutableStateOf(0) }
    val commercialStockCount = remember { mutableStateOf(0) }
    val financialStockCount = remember { mutableStateOf(0) }
    val selectedStockCount = remember { mutableStateOf(techStockCount) }

    val techStockPrice = remember { mutableStateOf(2.0) }
    val economyStockPrice = remember { mutableStateOf(2.0) }
    val commercialStockPrice = remember { mutableStateOf(2.0) }
    val financialStockPrice = remember { mutableStateOf(2.0) }

    // Track price increase or decrease
    val techPriceIncreased = remember { mutableStateOf(true) }
    val economyPriceIncreased = remember { mutableStateOf(true) }
    val commercialPriceIncreased = remember { mutableStateOf(true) }
    val financialPriceIncreased = remember { mutableStateOf(true) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            while (true) {
                delay(10000)
                updateStockPrice(techStockPrice, techPriceIncreased)
                updateStockPrice(economyStockPrice, economyPriceIncreased)
                updateStockPrice(commercialStockPrice, commercialPriceIncreased)
                updateStockPrice(financialStockPrice, financialPriceIncreased)
            }
        }
    }

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
                        selectedStockCount.value = techStockCount
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
                    text = "Price stock $${String.format("%.2f", techStockPrice.value)}",
                    fontSize = 12.sp,
                    color = if (techPriceIncreased.value) Color.Green else Color.Red
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
                        selectedStockCount.value = economyStockCount
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
                    text = "Price stock $${String.format("%.2f", economyStockPrice.value)}",
                    fontSize = 12.sp,
                    color = if (economyPriceIncreased.value) Color.Green else Color.Red
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
                        selectedStockCount.value = commercialStockCount
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
                    text = "Price stock $${String.format("%.2f", commercialStockPrice.value)}",
                    fontSize = 12.sp,
                    color = if (commercialPriceIncreased.value) Color.Green else Color.Red
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
                        selectedStockCount.value = financialStockCount
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
                    text = "Price stock $${String.format("%.2f", financialStockPrice.value)}",
                    fontSize = 12.sp,
                    color = if (financialPriceIncreased.value) Color.Green else Color.Red
                )
            }
        }
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Stock you are holding ${selectedStockCount.value.value}")
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        TextButton(
                            onClick = {
                                val stockPrice = when (selectedStockCount.value) {
                                    techStockCount -> techStockPrice.value
                                    economyStockCount -> economyStockPrice.value
                                    commercialStockCount -> commercialStockPrice.value
                                    financialStockCount -> financialStockPrice.value
                                    else -> 0.0
                                }
                                viewModel.buyStock(stockPrice)
                                selectedStockCount.value.value += 1
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Green
                            )
                        ) {
                            Text("Buy 1 stock")
                        }

                        TextButton(
                            onClick = {
                                if (selectedStockCount.value.value > 0) {
                                    val stockPrice = when (selectedStockCount.value) {
                                        techStockCount -> techStockPrice.value
                                        economyStockCount -> economyStockPrice.value
                                        commercialStockCount -> commercialStockPrice.value
                                        financialStockCount -> financialStockPrice.value
                                        else -> 0.0
                                    }
                                    viewModel.sellStock(stockPrice)
                                    selectedStockCount.value.value -= 1
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red
                            )
                        ) {
                            Text("Sell stock position")
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text("OK")
                }
            }
        )
    }
}

fun updateStockPrice(stockPrice: MutableState<Double>, priceIncreased: MutableState<Boolean>) {
    val chance = (1..100).random()
    if (chance <= 60) {
        stockPrice.value *= 1.3
        priceIncreased.value = true
    } else {
        stockPrice.value /= 1.3
        priceIncreased.value = false
    }
}
