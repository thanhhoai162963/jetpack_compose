package com.example.composetutorial.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun HomeScreen2(navController: NavController, demo: Int, rememberCount: String) {
    Box(
        Modifier
            .background(Color.Red)
            .fillMaxSize()
    ) {
        Text(text = rememberCount + demo)
        Button(onClick = {
        }) {
            navController.popBackStack()
        }
    }
}

