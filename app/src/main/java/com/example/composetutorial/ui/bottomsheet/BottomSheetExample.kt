package com.example.composetutorial.ui.bottomsheet

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetExample() {
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    Button(onClick = { scope.launch { sheetState.show() } }) {

    }
    ModalBottomSheet(sheetState = sheetState, onDismissRequest = {
        Toast.makeText(
            context,
            "ssss",
            Toast.LENGTH_SHORT
        ).show()
    }) {
        Button(onClick = {
            scope.launch { sheetState.show() }
        }) {

        }
        Button(onClick = {
            scope.launch {
                if (sheetState.isVisible) {
                    sheetState.hide()
                } else
                    sheetState.show()
            }

        }) {

        }
        Button(onClick = {
            scope.launch { sheetState.expand() }
        }) {

        }
    }

}