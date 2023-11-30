package com.example.composetutorial.ui.pager

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerExample2() {
    val statePager = rememberPagerState {
        10
    }
    val scope = rememberCoroutineScope()
    HorizontalPager(
        state = statePager,
        beyondBoundsPageCount = 3,
        pageSpacing = 30.dp,
        contentPadding = PaddingValues(20.dp)
    ) {
        Text(
            text = "$it",
            Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .clickable {
                    scope.launch {

                    }
                }
        )
        Log.d("currentPage", statePager.currentPage.toString())
        Log.d("targetPage", statePager.targetPage.toString())
        Log.d("settledPage", statePager.settledPage.toString())
    }
}

/*
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerExample2() {
    HorizontalPager(state =) {

    }
}*/
