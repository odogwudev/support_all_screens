package com.odogwudev.supportallscreens.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.odogwudev.supportallscreens.ui.devicemodes.DeviceModesRoute
import com.odogwudev.supportallscreens.ui.home.HomeRoute
import com.odogwudev.supportallscreens.utils.screen.ScreenClassifier

@Composable
fun SupportAllScreensNavGraph(
    screenClassifier: ScreenClassifier,
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home,
        modifier = modifier
    ) {
        composable(Destinations.Home) {
            HomeRoute(
                onDeviceModeButtonTap = { navController.navigate(Destinations.DeviceModes) },
                onLayoutModeButtonTap = { navController.navigate(Destinations.LayoutModes) }
            )
        }

        composable(Destinations.DeviceModes) {
            DeviceModesRoute(
                screenClassifier = screenClassifier
            )
        }

        composable(Destinations.LayoutModes) {

        }
    }
}