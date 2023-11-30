package com.example.composetutorial.ui.lazylist

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LayzyListExample() {
    val data = rememberUpdatedState(
        newValue = listOf(User(1), User(2), User(3), User(4), User(5)).toMutableStateList()
    )
    var count = remember {
        mutableIntStateOf(5)
    }
    Column {
        Button(
            onClick = {
                count.intValue++
                data.value.add(User(count.intValue))
            },
            Modifier
                .padding(start = 30.dp)
                .size(100.dp, 100.dp)
        ) {

        }
        LazyColumn(contentPadding = PaddingValues(horizontal = 30.dp, vertical = 50.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                item {

                }
                items(data.value, key = { it.id }) {
                    Row(
                        modifier = Modifier
                            .animateItemPlacement()
                            .fillMaxWidth()
                            .background(Color.Blue),
                    ) {
                        Text(


                            text = "${it.id}",
                        )
                    }

                    Log.d("bbb", "co")
                }

                /*itemsIndexed(listOf("1", "2", "3")) { index, item ->
                    Text(text = "$index $item")

                }*/
            })
    }


}

data class User(var id: Int)

@Composable
fun LazyGirdExample() {
    LazyVerticalGrid(modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(100), content = {
        items(100) {
            Text(text = "nguyen", Modifier.background(Color.Red))

        }
    })
}

@Composable
fun LazyVerticalStaggeredGridExample() {
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(100.dp), content = {
        items(100) {
            Text(text = "nguyen", Modifier.background(Color.Red))

        }
    })
}