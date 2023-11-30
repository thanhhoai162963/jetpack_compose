package com.example.composetutorial.ui.animation

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R
import com.example.composetutorial.util.UiState
import kotlin.math.roundToInt

@Composable
fun AnimExample123() {
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    AnimatedVisibility(visibleState = state, enter = scaleIn(keyframes {
        this.durationMillis = 3000
    }), exit = scaleOut()) {
        Image(painter = painterResource(id = R.drawable.baseline_20mp_24), contentDescription = "")
    }
    when {
        state.isIdle && state.currentState -> Log.d("bbb", "visible")
        !state.isIdle && state.currentState -> Log.d("bbb", "loading")
        state.isIdle && !state.currentState -> Log.d("bbb", "Invisible")
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimExample333() {
    var visible by remember { mutableStateOf(false) }
    Button(onClick = { visible = !visible }) {

    }
    AnimatedVisibility(visible = visible, enter = fadeIn(keyframes {
        this.durationMillis = 2000
    }), exit = fadeOut(keyframes {
        this.durationMillis = 5000
    })
    ) {
        // Fade in/out the background and the foreground.
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
        ) {
            Box(Modifier
                .align(Alignment.Center)
                .animateEnterExit(
                    // Slide in/out the inner box.
                    enter = slideInVertically(keyframes {
                        this.durationMillis = 3000
                    }) { 430 }/*exit = slideOutVertically(keyframes {
                            this.durationMillis = 4000
                        }*/
                )
                .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                .background(Color.Red)
            ) {
                // Content of the notification…
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExample() {
    var uiState by remember { mutableStateOf(UiState.Loading) }
    AnimatedContent(targetState = uiState, transitionSpec = {
        fadeIn(animationSpec = tween(3000)).togetherWith(fadeOut(animationSpec = tween(3000)))
    }, modifier = Modifier.clickable {
        uiState = when (uiState) {
            UiState.Loading -> UiState.Loaded
            UiState.Loaded -> UiState.Error
            UiState.Error -> UiState.Loading
            else -> {}
        }
    }, label = "") {
        when (it) {

        }
    }
}

@Composable
fun AnimatedExpanded() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .background(Color.Red)
        .animateContentSize()
        .fillMaxWidth()
        .height(if (expanded) 400.dp else 200.dp)
        .clickable {
            expanded = !expanded
        })
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AnimatedOffset() {
    var move by remember {
        mutableStateOf(false)
    }
    val pxtoInt = with(LocalDensity.current) {
        100.dp.toPx().roundToInt()
    }
    val offset by animateIntOffsetAsState(
        targetValue = if (move) {
            IntOffset(pxtoInt, pxtoInt)
        } else {
            IntOffset.Zero
        }, label = ""
    )
    Box(modifier = Modifier
        .offset { offset }
        .background(Color.Red)
        .size(100.dp)
        .clickable {
            move = !move
        })
}

@Composable
fun AnimationOffSetNotStack() {
    var turn by remember { mutableStateOf(false) }
    val dpToPx = with(LocalDensity.current) { 150.dp.toPx().roundToInt() }
    val offset by animateIntOffsetAsState(
        targetValue = if (turn) {
            IntOffset(
                dpToPx, dpToPx
            )
        } else {
            IntOffset.Zero
        }, label = ""
    )
    Column {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(100.dp)
        )
        Box(modifier = Modifier
            .layout { measurable, constraints ->
                val placeable = measurable.measure(constraints)
                layout(placeable.width + offset.x, placeable.height + offset.y) {
                    placeable.placeRelative(offset)
                }
            }
            .background(Color.Blue)
            .size(100.dp)
            .clickable {
                turn = !turn
            })
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(100.dp)
        )
    }
}

@Composable
fun AnimationPadding() {
    var turn by remember {
        mutableStateOf(false)
    }
    val paddingvalue by animateDpAsState(targetValue = if (turn) 30.dp else 10.dp, label = "")
    Box(modifier = Modifier
        .padding(paddingvalue)
        .fillMaxSize()
        .background(Color.Red)
        .clickable { turn = !turn })
}

@Composable
fun AnimationColor() {

}