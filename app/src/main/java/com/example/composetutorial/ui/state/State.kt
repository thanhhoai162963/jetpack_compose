package com.example.composetutorial.ui.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetutorial.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class State {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun StateHoisting(value: String, onChange: (String) -> Unit) {
        OutlinedTextField(value = value, onValueChange = onChange)
    }

    @Composable
    fun NotStateHoist(count: Int?) {
        Column {
            ClickableText(text = AnnotatedString("thanh"), onClick = { count })
            Text(text = count.toString())
        }

    }

    @Composable
    fun ScreenChat() {
        val data = mutableListOf<Int>()
        val lazyListState = rememberLazyListState()
        val scope = rememberCoroutineScope()

        for (i in 1..40) {
            data.add(i)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ListMess(data, lazyListState)
            Button(onClick = {
                scope.launch {
                    lazyListState.scrollToItem(0)
                }
            }) {
                Text(text = "Demo", color = Color.White)
            }
        }

    }

    @Composable
    fun ListMess(list: List<Int>, lazyListState: LazyListState) {
        LazyColumn(
            state = lazyListState
        ) {
            items(count = list.size, key = { it }) {
                Text(text = "$it")
            }
        }
    }

    @Composable
    fun SetUI() {
        val viewModel = viewModel<MainViewModel>()
        val data = viewModel.getData().collectAsState()

        LazyColumn {
            items(data.value.size) {
                Text(text = "$it")
            }
        }
    }
}

