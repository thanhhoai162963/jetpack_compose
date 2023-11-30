package com.example.composetutorial.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onClick: (Int) -> Unit) {
    val count by remember {
        mutableIntStateOf(1)
    }
    Box(
        Modifier
            .background(Color.Blue)
            .width(100.dp)
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(onClick = {
            }) {
                Text(text = "co the null")
            }

            Button(onClick = {
                onClick.invoke(count)
            }) {
                Text(text = "chuyen sang man hinh khac")
            }
        }

    }
}