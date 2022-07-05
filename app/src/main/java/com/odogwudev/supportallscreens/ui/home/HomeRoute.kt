package com.odogwudev.supportallscreens.ui.home

import androidx.compose.runtime.Composable

@Composable
fun HomeRoute(
    onDeviceModeButtonTap: () -> Unit,
    onLayoutModeButtonTap: () -> Unit
) {
    HomeScreen(
        onDeviceModeButtonTap = onDeviceModeButtonTap,
        onLayoutModeButtonTap = onLayoutModeButtonTap
    )
}
