package com.example.composetutorial.ui.resource

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R

@Composable
fun ResourceExample123() {
    Text(text = stringResource(id = R.string.app_name), fontStyle = FontStyle(R.font.roboto_black))
    val dimen = dimensionResource(id = R.dimen.font_big)
    Text(
        text = stringResource(id = R.string.app_name),
        Modifier.size(100.dp, dimen)
    )
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = ""
    )


}