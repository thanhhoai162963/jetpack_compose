package com.example.composetutorial.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AccountScreen(data: String?, navigationOnClick: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Red)
            .padding(50.dp)
            .width(100.dp)
            .height(100.dp)
            .clickable { navigationOnClick.invoke(1) }
    )
    if (data != null) {
        Text(text = data)
    }
}

