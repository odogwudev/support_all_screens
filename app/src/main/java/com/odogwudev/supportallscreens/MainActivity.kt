package com.odogwudev.supportallscreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.lifecycleScope
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowLayoutInfo
import com.odogwudev.supportallscreens.ui.SupportAllScreen
import com.odogwudev.supportallscreens.utils.screen.rememberWindowDpSize
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val devicePosture = WindowInfoTracker
            .getOrCreate(this)
            .windowLayoutInfo(this)
            .stateIn(
                scope = lifecycleScope,
                started = SharingStarted.Eagerly,
                initialValue = WindowLayoutInfo(emptyList())
            )

        setContent {
            val windowDpSize = rememberWindowDpSize(this)
            SupportAllScreen(
                devicePosture = devicePosture,
                windowDpSize = windowDpSize
            )
        }
    }
}


//reading foldable data common(Honge Position, Hinge Seperation Ratio, Is Seperating, Oclusion type)