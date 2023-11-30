package com.example.composetutorial.ui.compositionlocal

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.composetutorial.R

class CompositionLocalExample {
    @Composable
    fun Demo() {
        CompositionLocalProvider(LocalAppProvider provides ABC()) {
            Text(
                text = LocalContext.current.getString(R.string.app_name),
                color = LocalAppProvider.current.color
            )
        }


    }

    @Composable
    fun Demo2() {

    }
}

data class ABC(var color: Color = Color.White)

val LocalAppProvider = compositionLocalOf { ABC() }



