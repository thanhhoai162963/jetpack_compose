@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composetutorial

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetutorial.model.Doctor2
import com.example.composetutorial.model.Support
import com.example.composetutorial.ui.SideEffects.SideEffect
import com.example.composetutorial.ui.adaptivelayout.WindowSize
import com.example.composetutorial.ui.adaptivelayout.rememberWindowSizeClass
import com.example.composetutorial.ui.animation.AnimatedContentExample
import com.example.composetutorial.ui.animation.AnimatedOffset
import com.example.composetutorial.ui.animation.AnimationOffSetNotStack
import com.example.composetutorial.ui.animation.AnimationPadding
import com.example.composetutorial.ui.state.State
import com.example.composetutorial.viewmodel.MainViewModel
import kotlinx.parcelize.Parcelize

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    private val LocalColor = compositionLocalOf { Color.Red }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //uri=android-app://androidx.navigation/home2/1000/userId
        setContent {
            AnimatedContentExample()
            val windowSize = rememberWindowSizeClass()
            val data = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()
            val context = LocalContext.current
            val viewModel = viewModel(MainViewModel::class.java)
            when (windowSize.widthWindowSizeClass) {
                is WindowSize.WindowType.COMPACT -> {
                    AnimationPadding()
                    /*Box(modifier = Modifier.fillMaxSize()) {


                    }*/
                }

                is WindowSize.WindowType.MEDIUM -> {
                    // AppScreenMedium()
                    Log.d("bbb", "MEDIUM")

                }

                else -> {
                    var count by rememberSaveable {
                        mutableIntStateOf(10)
                    }
                    Text(text = "$count")
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    }
                }
            }
        }
    }

    @Composable
    fun Demo444(onValueChange: (Int) -> Unit) {
        var count123 = 0
        Button(onClick = { onValueChange.invoke(++count123) }) {
            // Text(text = count.value.toString())
        }
    }

    @Composable
    fun DemoButton() {
        Column {
            Button(
                onClick = {

                }, enabled = true, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue, contentColor = Color.Gray
                )
            ) {
                Text(text = "ttttt")
            }
            FloatingActionButton(onClick = { /*TODO*/ }) {

            }
            ElevatedButton(onClick = { /*TODO*/ }) {

            }
            TextButton(onClick = { /*TODO*/ }) {

            }
        }


    }

    @Composable
    fun Remember() {
        Box {
            Text(
                text = "tsssssssssssshanh", color = LocalColor.current
            )
        }
    }

    @Composable
    fun LizAITextFiled2(doctor2: Doctor2) {
        Text(text = doctor2.id.toString(), fontSize = 15.sp)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LizAITextFiled(data: String, change: (String) -> Unit) {

        TextField(value = data, onValueChange = change)
    }

    @Composable
    fun DemoKey123(data: List<Support>) {
        Column {
            for (i in data) {
                Text(text = "$i")
            }
        }
    }

    @Composable
    fun Demo222() {
        var id by rememberSaveable { mutableStateOf(0) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                id += 1
            }) {
                Text(text = "nhap di")
            }
            Log.d("ccc", "$id")
            // SideEffect().RememberUpdatedStateExample(number = id)

        }
    }

    @Composable
    fun Demo33333(context: Context) {
        Column {
            val viewModel = viewModel<MainViewModel>()
            SideEffect().RememberCoroutineScope(viewModel, 1, context)
        }
    }

    @Composable
    fun UseRemember() {
        State().SetUI()
    }

    @Composable
    fun Demo123() {
        var data by rememberSaveable {
            mutableStateOf("")
        }
        State().StateHoisting(value = "thanh", onChange = { data = it })

    }

    @Composable
    fun DemoKey(item: List<String>) {

        Column {
            for (i in item) {
                key(i) {

                }
            }
        }
    }

    @Composable
    fun Demo(a: String) {
        Text(text = a)
    }

    @Composable
    fun Demo333() {
        Surface {
            Column {
                Row {
                    Text(text = "Hello,\nWorld", color = Color.White)
                    Button(onClick = { }) {
                        Text(text = "Show more")
                    }
                }
                Row {
                    Text(text = "Hello,\nWorld", color = Color.White)
                    Button(onClick = { }) {
                        Text(text = "Show more")
                    }
                }
            }
        }

    }
}

@Parcelize
data class User(var name: String?) : Parcelable