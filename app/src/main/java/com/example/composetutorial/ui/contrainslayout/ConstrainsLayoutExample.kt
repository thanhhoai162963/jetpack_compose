package com.example.composetutorial.ui.contrainslayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun TwoTexts() {
    Row(Modifier.height(IntrinsicSize.Min)) {
        Text(
            text = "thanh",
            modifier = Modifier
                .weight(1f)
                .height(400.dp)
                .background(Color.Blue)
                .wrapContentSize(),
            color = Color.White
        )
        Divider(
            Modifier
                .fillMaxHeight()
                .width(10.dp)
                .background(Color.Red)
        )
        Text(
            text = "vy",
            modifier = Modifier
                .weight(1f)
                .height(300.dp)
                .background(Color.Blue)
                .wrapContentSize(),
        )
    }
}

@Preview
@Composable
fun TwoTextsPreview() {
    MaterialTheme {
        Surface {

        }
    }
}

@Composable
fun ConstrainLayoutExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (button1, button2, button3, button4) = createRefs()
        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(button1) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }) {

        }
        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(button2) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        }) {

        }
        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(button3) {
            top.linkTo(button1.bottom)
        }) {

        }
        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(button4) {
            start.linkTo(button3.end)
            top.linkTo(button1.bottom)
        }) {

        }
    }
}



