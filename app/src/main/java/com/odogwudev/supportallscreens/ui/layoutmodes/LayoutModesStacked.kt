package com.odogwudev.supportallscreens.ui.layoutmodes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.odogwudev.supportallscreens.utils.screen.ScreenClassifier

@Composable
fun LayoutModesStacked(
    screenClassifier: ScreenClassifier.HalfOpened.TableTopMode,
    uiState: LayoutModesUiState,
    onSelectArticle: () -> Unit
) {

    Column {
        Box(modifier = Modifier.fillMaxHeight(screenClassifier.hingeSeparationRatio)) {
            LayoutModesListScreen(
                onSelectArticle = onSelectArticle
            )
        }

        Box(modifier = Modifier.fillMaxHeight()) {
            LayoutModesDetailsScreen(
                uiState = uiState
            )
        }
    }
}
