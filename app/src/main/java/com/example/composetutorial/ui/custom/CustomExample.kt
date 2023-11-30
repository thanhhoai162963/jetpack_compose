package com.example.composetutorial.ui.custom

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class CustomExample {

    /*private fun Modifier.firstBaselineToTop(firstBaselineToTop: Dp) =
        layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            val placeableY = firstBaselineToTop.roundToPx() - placeable[FirstBaseline]
            val height = placeableY + placeable.height


        }*/

    @Preview
    @Composable
    fun TextWithPaddingToBaselinePreview() {
        Text(
            "Hi there!",
            Modifier
                // .firstBaselineToTop(150.dp)
                .background(Color.Red)
        )
    }

}