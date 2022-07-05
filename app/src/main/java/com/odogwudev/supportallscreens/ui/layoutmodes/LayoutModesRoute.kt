package com.odogwudev.supportallscreens.ui.layoutmodes

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.odogwudev.supportallscreens.utils.screen.ScreenClassifier
import com.odogwudev.supportallscreens.utils.screen.WindowSizeClass

@Composable
fun LayoutModesRoute(
    layoutModesViewModel: LayoutModesViewModel,
    screenClassifier: ScreenClassifier
) {
    val uiState by layoutModesViewModel.uiState.collectAsState()

    LayoutModesRoute(
        screenClassifier = screenClassifier,
        uiState = uiState,
        onBackPressed = { layoutModesViewModel.closeDetails() },
        onSelectArticle = { layoutModesViewModel.openDetails() }
    )
}

@Composable
fun LayoutModesRoute(
    screenClassifier: ScreenClassifier,
    uiState: LayoutModesUiState,
    onBackPressed: () -> Unit,
    onSelectArticle: () -> Unit
) {
    var layoutModesScreenType by rememberSaveable { mutableStateOf(LayoutModesScreenType.ListOnly) }
    layoutModesScreenType =
        screenClassifier.toLayoutModesScreenType(articleSelected = uiState.detailsSelected)

    when (layoutModesScreenType) {
        LayoutModesScreenType.ListOnly -> LayoutModesListScreen(
            onSelectArticle = onSelectArticle
        )

        LayoutModesScreenType.DetailOnly -> {
            LayoutModesDetailsScreen(
                uiState = uiState
            )

            BackHandler {
                onBackPressed()
            }
        }

        LayoutModesScreenType.ListOneThirdAndDetailTwoThirds -> LayoutModesListOneThirdAndDetailTwoThirds(
            uiState = uiState,
            onSelectArticle = onSelectArticle
        )

        LayoutModesScreenType.ListHalfAndDetailHalf -> {
            check(screenClassifier is ScreenClassifier.HalfOpened.BookMode)

            LayoutModesListHalfAndDetailHalf(
                screenClassifier = screenClassifier,
                uiState = uiState,
                onSelectArticle = onSelectArticle
            )
        }

        LayoutModesScreenType.ListDetailStacked -> {
            check(screenClassifier is ScreenClassifier.HalfOpened.TableTopMode)

            LayoutModesStacked(
                screenClassifier = screenClassifier,
                uiState = uiState,
                onSelectArticle = onSelectArticle
            )
        }
    }
}

enum class LayoutModesScreenType {
    ListOnly,
    DetailOnly,
    ListOneThirdAndDetailTwoThirds,
    ListHalfAndDetailHalf,
    ListDetailStacked
}

@Composable
private fun ScreenClassifier.toLayoutModesScreenType(articleSelected: Boolean) =
    if (this is ScreenClassifier.FullyOpened && width.sizeClass == WindowSizeClass.Expanded) {
        LayoutModesScreenType.ListOneThirdAndDetailTwoThirds
    } else if (this is ScreenClassifier.FullyOpened && !articleSelected) {
        LayoutModesScreenType.ListOnly
    } else if (this is ScreenClassifier.FullyOpened && articleSelected) {
        LayoutModesScreenType.DetailOnly
    } else if (this is ScreenClassifier.HalfOpened.BookMode) {
        LayoutModesScreenType.ListHalfAndDetailHalf
    } else if (this is ScreenClassifier.HalfOpened.TableTopMode) {
        LayoutModesScreenType.ListDetailStacked
    } else {
        LayoutModesScreenType.ListOnly
    }
