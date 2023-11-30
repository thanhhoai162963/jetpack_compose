package com.example.composetutorial.ui.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun LinearProgressExample() {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false // Reset loading when the coroutine finishes
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = currentProgress
            )
        }
    }
}

@Preview
@Composable
fun CircularProgressExample() {
    var currentProgress by remember {
        mutableFloatStateOf(0f)
    }
    val scope = rememberCoroutineScope()
    var loading by remember {
        mutableStateOf(false)
    }
    Column {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress {
                    currentProgress = it
                }
                loading = false
            }
        }, enabled = !loading) {
        }
        if (loading) {
            CircularProgressIndicator(progress = currentProgress)
        }

    }
}

/** Iterate the progress value */
suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

@Composable
fun IndeterminateProgress() {
    Column {
        CircularProgressIndicator(
            modifier = Modifier.wrapContentSize(),
            color = Color.Blue,
            trackColor = Color.Yellow,
        )
        LinearProgressIndicator(
            modifier = Modifier.wrapContentSize(),
            color = Color.Blue,
            trackColor = Color.Yellow,
        )
    }

}

