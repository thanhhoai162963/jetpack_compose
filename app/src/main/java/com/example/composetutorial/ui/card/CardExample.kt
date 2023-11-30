package com.example.composetutorial.ui.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CardExample {

    @Preview(showBackground = true)
    @Composable
    fun Demo() {
        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.Red)
        ) {
            Text(text = "thanh")
        }
    }
}