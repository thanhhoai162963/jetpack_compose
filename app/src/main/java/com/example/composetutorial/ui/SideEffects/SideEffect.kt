package com.example.composetutorial.ui.SideEffects

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.example.composetutorial.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SideEffect {
    @Composable
    fun LaunchedEffect123(viewModel: MainViewModel) {
        val data123 by viewModel.getData123().collectAsState()
        var recom by remember {
            mutableStateOf(true)
        }
        Column {
            Button(onClick = { recom = !recom }) { }
            LaunchedEffect(block = {
                viewModel.getSingleUser(1)
            }, key1 = Unit)

            data123.data?.avatar?.let { Text(text = it) }

        }


    }

    @Composable
    fun RememberCoroutineScope(viewModel: MainViewModel, id: Int, context: Context) {
        val data = rememberCoroutineScope()
        Button(onClick = { data.launch(Dispatchers.IO) { } }) {

        }

    }

    @Composable
    fun RememberUpdatedStateExample(someValue: Int) {
        val rememberedValue by rememberUpdatedState(someValue)
        val rememberValue by remember { mutableStateOf(someValue) }

        Text(text = rememberedValue.toString())
        Text(text = rememberValue.toString())
    }

    @Composable
    fun DisposableEffectExample() {
        DisposableEffect(key1 = true) {
            onDispose {

            }
        }
    }

    @Composable
    fun SideEffectExample() {
        val rememberState by remember {
            mutableStateOf(0)
        }
        /* androidx.compose.runtime.SideEffect {
             val data = Data(id = rememberState,)
         }*/
    }

    @Composable
    fun ProductionEffect(url: String): State<String> {
        return produceState(initialValue = "", producer = {
            value = url
        })
    }

    @Composable
    fun DerivedOfState() {
        val stateLazyColumn = rememberLazyListState()
        Column {
            LazyColumn(state = stateLazyColumn, content = {
                items(100) {
                    Text(text = "thanh")
                }
            })
            val showButton by remember {
                derivedStateOf {
                    stateLazyColumn.firstVisibleItemIndex > 0
                }
            }
            Log.d("bbb", showButton.toString())
            Text(text = "hoai$showButton")
        }
    }

    @Composable
    fun SnapShowFlow() {
        val rememberState by remember {
            mutableStateOf("")
        }
        snapshotFlow { rememberState }
    }
}
