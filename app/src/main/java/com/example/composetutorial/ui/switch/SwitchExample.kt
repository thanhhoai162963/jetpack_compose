package com.example.composetutorial.ui.switch

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun SwitchExample() {
    var checkState by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = checkState,
        onCheckedChange = { checkState = it },
        colors = SwitchDefaults.colors(
            checkedTrackColor = Color.White,
            uncheckedTrackColor = Color.White,
            checkedThumbColor = Color.Blue,
            uncheckedThumbColor = Color.Gray
        )
    )
}