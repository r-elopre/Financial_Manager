package com.example.financialmanager.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financialmanager.R

@Composable
fun FamilyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.family2),
                contentDescription = "Family",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .padding(top = 30.dp)
            ) {
                Text(
                    text = "We need Support",
                    color = Color.White,
                    fontSize = 13.sp
                )
                Text(
                    text = "please give me money",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
        }
    }
}