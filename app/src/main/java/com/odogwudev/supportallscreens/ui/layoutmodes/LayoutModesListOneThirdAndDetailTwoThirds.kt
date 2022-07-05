package com.odogwudev.supportallscreens.ui.layoutmodes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LayoutModesListOneThirdAndDetailTwoThirds(
    uiState: LayoutModesUiState,
    onSelectArticle: () -> Unit
) {
    Row {
        Box(modifier = Modifier.fillMaxWidth(0.33f)) {
            LayoutModesListScreen(
                onSelectArticle = onSelectArticle
            )
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            LayoutModesDetailsScreen(
                uiState = uiState
            )
        }
    }
}
