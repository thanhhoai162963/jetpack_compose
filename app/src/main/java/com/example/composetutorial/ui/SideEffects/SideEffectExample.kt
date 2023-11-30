package com.example.composetutorial.ui.SideEffects

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import com.example.composetutorial.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun SideEffectExample(viewModel: MainViewModel = MainViewModel()) {
    val data by viewModel.getData123().collectAsState()
    var run by remember { mutableStateOf(false) }
    Button(onClick = { run = !run }) {
    }
    LaunchedEffect(key1 = run) {
        viewModel.getSingleUser(1)
    }
    data.data?.email?.let { Text(text = it) }

}

@Composable
fun RememberCoroutineExample(viewModel: MainViewModel = MainViewModel()) {
    val data by viewModel.getData123().collectAsState()
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            viewModel.getSingleUser(1)
        }
    }) {
        data.data?.email?.let {
            Text(text = it, Modifier.onSizeChanged {

            })
        }
    }
}

@Composable
fun RememberUpdateStateExample(count: Int) {
    val demo = rememberUpdatedState(newValue = count)
}

@Composable
fun DisposableExmaple(viewModel: MainViewModel = MainViewModel()) {
    val context = LocalContext.current
    var demo by remember {
        mutableStateOf(false)
    }
    Button(onClick = { demo = !demo }) {

    }
    DisposableEffect(key1 = demo, effect = {
        viewModel.getSingleUser(1)
        onDispose {
            Toast.makeText(context, "ssss", Toast.LENGTH_SHORT).show()
        }
    })
}

@Composable
fun Sis(viewModel: MainViewModel = MainViewModel()) {
    val count by remember {
        mutableIntStateOf(1)
    }

    androidx.compose.runtime.SideEffect {
        User(count)

    }
}

data class User(var id: Int)

