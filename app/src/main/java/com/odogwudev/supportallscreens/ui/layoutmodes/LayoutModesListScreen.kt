package com.odogwudev.supportallscreens.ui.layoutmodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.odogwudev.supportallscreens.R
import com.odogwudev.supportallscreens.ui.theme.SupportAllScreensTheme

@Composable
fun LayoutModesListScreen(
    onSelectArticle: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        Button(
            onClick = { onSelectArticle() }
        ) {
            Text(text = stringResource(id = R.string.list_item))
        }
    }
}

@Preview(name = "Default Preview")
@Composable
fun PreviewLayoutModesListScreen() {
    SupportAllScreensTheme() {
        LayoutModesListScreen(
            onSelectArticle = { }
        )
    }
}
