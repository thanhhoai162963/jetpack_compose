package com.example.composetutorial.ui.chip

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.composetutorial.R

class ChipExample {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DemoAssistChip() {
        AssistChip(onClick = { /*TODO*/ }, label = { /*TODO*/ })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FilterChipExample() {
        var state by remember {
            mutableStateOf(false)
        }
        FilterChip(selected = state,
            onClick = { state = !state },
            label = { Text(text = "thanh") },
            leadingIcon = if (state) {
                {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = ""
                    )
                }
            } else {
                null
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputChipExample(
        text: String,
        onDismiss: () -> Unit,
    ) {
        var enabled by remember { mutableStateOf(true) }
        if (!enabled) return

        InputChip(
            onClick = {
                onDismiss()
                enabled = !enabled
            },
            label = { Text(text) },
            selected = enabled,
            avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SuggestionChipExample() {
        SuggestionChip(
            onClick = { Log.d("Suggestion chip", "hello world") },
            label = { Text("Suggestion chip") }
        )
    }
}