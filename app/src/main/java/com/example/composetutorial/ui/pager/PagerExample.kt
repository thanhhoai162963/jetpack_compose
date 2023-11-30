package com.example.composetutorial.ui.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R

class PagerExample {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun DemoHorizontal() {
        val statePage = rememberPagerState(initialPage = 0) {
            10
        }
        HorizontalPager(state = statePage, Modifier.fillMaxSize()) {
            Box {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                )
            }

        }
    }

    @ExperimentalFoundationApi
    private val threePagesPerViewport = object : PageSize {
        override fun Density.calculateMainAxisPageSize(
            availableSpace: Int,
            pageSpacing: Int
        ): Int {
            return (availableSpace - 2 * pageSpacing) / 3
        }
    }

    @Preview(showBackground = true)
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun DemoHorizontalImage() {
        val pagerState = rememberPagerState(initialPage = 0) {
            10
        }
        HorizontalPager(
            state = pagerState,
            beyondBoundsPageCount = 3,
            contentPadding = PaddingValues(start = 64.dp, end = 60.dp),
            pageSize = threePagesPerViewport,
            modifier = Modifier.padding(end = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
            )
        }
    }
}