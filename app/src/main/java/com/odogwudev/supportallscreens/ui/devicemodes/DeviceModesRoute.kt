package com.odogwudev.supportallscreens.ui.devicemodes

import androidx.compose.runtime.Composable
import com.odogwudev.supportallscreens.utils.screen.ScreenClassifier

@Composable
fun DeviceModesRoute(
    screenClassifier: ScreenClassifier
) {
    DeviceModesScreen(
        screenClassifier = screenClassifier
    )
}
