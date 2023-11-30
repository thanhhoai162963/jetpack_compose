package com.example.composetutorial.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AccountScreen3(userId: Int?, navigationClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize()
    ) {
        Column {
            Text(text = "$userId")
            Button(onClick = { navigationClick.invoke() }) {

            }
        }

    }
}