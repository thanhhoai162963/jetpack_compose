package com.example.composetutorial.ui.text

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun TextFieldExample() {
    var data by remember {
        mutableStateOf("")
    }
    SelectionContainer {
        TextField(
            value = data,
            onValueChange = { data = it },
            textStyle = TextStyle(color = Color.Blue),
            keyboardOptions = KeyboardOptions(
                KeyboardCapitalization.Characters,
                autoCorrect = true, KeyboardType.Password,
                ImeAction.Done
            )
        )

    }

}