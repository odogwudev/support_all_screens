package com.odogwudev.supportallscreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.odogwudev.supportallscreens.ui.SupportAllScreen
import com.odogwudev.supportallscreens.utils.screen.rememberWindowDpSize

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowDpSize = rememberWindowDpSize(this)
            SupportAllScreen(
                windowDpSize = windowDpSize
            )
        }
    }
}
