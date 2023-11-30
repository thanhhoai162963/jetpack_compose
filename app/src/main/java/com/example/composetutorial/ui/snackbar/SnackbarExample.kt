package com.example.composetutorial.ui.snackbar

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackbarExample() {
    val scope = rememberCoroutineScope()
    val state = remember {
        SnackbarHostState()
    }
    SnackbarHost(state) {
        Snackbar(snackbarData = it)
    }
    Button(onClick = {
        scope.launch {
            val result =
                state.showSnackbar("thanh", "nguyen", duration = SnackbarDuration.Indefinite)
            when (result) {
                SnackbarResult.ActionPerformed -> {

                }

                SnackbarResult.Dismissed -> {

                }

            }
        }
    }) {

    }
}