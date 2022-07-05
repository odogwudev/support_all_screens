package com.odogwudev.supportallscreens.utils.screen

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toComposeRect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.window.layout.WindowMetricsCalculator

@Composable
fun rememberWindowDpSize(activity: Activity): DpSize {
    val configuration = LocalConfiguration.current  //reference to current screen

    //pass to remember so it survives recomposition
    val windowMetrics = remember(configuration) {
        WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(activity)
    }

    //transform into a dp oject
    val windowDpSize = with(LocalDensity.current) {
        windowMetrics.bounds.toComposeRect().size.toDpSize()//get bounds then convert to rectangle to get dpsize
    }

    return windowDpSize
}