package com.example.composetutorial.ui.image

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Preview(showBackground = true)
@Composable
fun ImageExample() {
    AsyncImage(
        model = "https://prod-apis.lizai.co/images/logo/lizai-logo-white.png?1698742353",
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .border(BorderStroke(10.dp, Color.Red), shape = CircleShape)
            .size(100.dp, 100.dp),
        onLoading = {

        }, onSuccess = {

        },
        onError = {

        }
    )
}

@Preview(showBackground = true)
@Composable
fun ImageExample2() {
    AsyncImage(
        ImageRequest.Builder(LocalContext.current).crossfade(true)
            .data("https://prod-apis.lizai.co/images/logo/lizai-logo-white.png?1698742353").build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .border(BorderStroke(10.dp, Color.Red), shape = CircleShape)
            .size(100.dp, 100.dp),
        onLoading = {

        }, onSuccess = {

        },
        onError = {

        }
    )
}

@Preview(showBackground = true)
@Composable
fun ImageExample3() {
    val data =
        rememberAsyncImagePainter(model = "https://prod-apis.lizai.co/images/logo/lizai-logo-white.png?1698742353")
    Image(painter = data, contentDescription = "")
}