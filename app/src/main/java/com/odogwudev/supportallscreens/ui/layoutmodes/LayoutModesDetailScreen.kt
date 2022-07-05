package com.odogwudev.supportallscreens.ui.layoutmodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
fun LayoutModesDetailsScreen(
    uiState: LayoutModesUiState
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxSize()
    ) {
        if (uiState.detailsSelected) {
            Text(
                text = stringResource(id = R.string.article_content),
                color = Color.White
            )
        } else {
            Text(
                text = stringResource(id = R.string.no_article),
                color = Color.White
            )
        }
    }
}

@Preview(name = "Default Preview")
@Composable
fun PreviewLayoutModesDetailsScreen() {
    SupportAllScreensTheme() {
        LayoutModesDetailsScreen(
            uiState = LayoutModesUiState(
                detailsSelected = true
            )
        )
    }
}
