package com.example.composetutorial.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AccountScreen2(navigationOnClick: (Int) -> Unit, number: Int?) {
    val count by remember {
        mutableIntStateOf(1)
    }
    Column {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(50.dp)
                .wrapContentSize()
                .clickable {
                    navigationOnClick.invoke(count)
                }
        )
        Text(text = "$number")
    }


}