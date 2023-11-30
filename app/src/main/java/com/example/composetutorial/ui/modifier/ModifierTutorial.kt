package com.example.composetutorial.ui.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ModifierTutorial(modifier: Modifier) {
    Column(modifier = modifier.then(Modifier.background(Color.DarkGray))) {
        Text(text = "thanh",
            Modifier
                .weight(1f)
                .background(Color.White))
    }
}