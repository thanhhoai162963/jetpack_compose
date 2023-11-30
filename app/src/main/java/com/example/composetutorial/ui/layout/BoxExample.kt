package com.example.composetutorial.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.R


class BoxExample {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Demo() {/*Card(
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Blue),
        ) {
            Box(
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = ""
                )
                Text(text = "ggg")
            }
        }*/
    }

    @Preview(showBackground = true)
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldExample() {
        Scaffold(floatingActionButton = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "sss"
                )
            }
        }, topBar = {
            TopAppBar(title = { Text(text = "demo") }, navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "sss"
                    )
                }
            }, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "sss"
                    )
                }
            })
        }, bottomBar = {
            BottomAppBar(containerColor = Color.Red) {

            }
        }) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

            }
        }
    }

}