package com.odogwudev.supportallscreens.ui.layoutmodes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.odogwudev.supportallscreens.utils.screen.ScreenClassifier

@Composable
fun LayoutModesListHalfAndDetailHalf(
    screenClassifier: ScreenClassifier.HalfOpened.BookMode,
    uiState: LayoutModesUiState,
    onSelectArticle: () -> Unit
) {

    Row {
        Box(modifier = Modifier.fillMaxWidth(screenClassifier.hingeSeparationRatio)) {
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
