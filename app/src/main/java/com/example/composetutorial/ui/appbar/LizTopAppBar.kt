package com.example.composetutorial.ui.appbar

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.composetutorial.R

class LizTopAppBar {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("NotConstructor")
    @Composable
    fun LizTopAppBarr(
        modifier: Modifier, title: String, iconBack: Int, action1: () -> Unit, action2: () -> Unit
    ) {
        TopAppBar(title = {
            Text(text = title)
        }, modifier = modifier, actions = {
            IconButton(onClick = {
                action1
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = ""
                )
            }
            IconButton(onClick = { action2 }) {
                action2
            }
        })
    }
}