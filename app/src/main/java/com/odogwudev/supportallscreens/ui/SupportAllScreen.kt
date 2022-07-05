package com.odogwudev.supportallscreens.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.WindowLayoutInfo
import com.odogwudev.supportallscreens.ui.navigation.SupportAllScreensNavGraph
import com.odogwudev.supportallscreens.ui.theme.SupportAllScreensTheme
import com.odogwudev.supportallscreens.utils.screen.ScreenInfo
import kotlinx.coroutines.flow.StateFlow

@ExperimentalMaterial3Api
@Composable
fun SupportAllScreen(
    windowDpSize: DpSize,
    screenInfo: ScreenInfo = ScreenInfo()
) {
    val screenClassifier = screenInfo.createClassifier(windowDpSize)

    SupportAllScreensTheme() {
        val navController = rememberNavController()

        Scaffold { innerPadding ->
            SupportAllScreensNavGraph(
                screenClassifier = screenClassifier,
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )

        }
    }
}
