package com.odogwudev.supportallscreens.ui.devicemodes

import android.graphics.Rect
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odogwudev.supportallscreens.R
import androidx.window.layout.FoldingFeature
import com.odogwudev.supportallscreens.ui.theme.SupportAllScreensTheme
import com.odogwudev.supportallscreens.utils.screen.ScreenClassifier

@Composable
fun DeviceModesScreen(
    screenClassifier: ScreenClassifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(
                text = screenClassifier::class.java.simpleName,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = screenClassifier.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            if (screenClassifier is ScreenClassifier.HalfOpened) {
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = stringResource(id = R.string.hinge_position),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "T: ${screenClassifier.hingePosition.top}, B: ${screenClassifier.hingePosition.bottom}, L: ${screenClassifier.hingePosition.left}, R: ${screenClassifier.hingePosition.right}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "W: ${screenClassifier.hingePosition.width()}, H: ${screenClassifier.hingePosition.height()}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(name = "Foldable Book Mode", showBackground = true)
@Composable
fun PreviewBookMode() {
    SupportAllScreensTheme() {
        DeviceModesScreen(
            screenClassifier = ScreenClassifier.HalfOpened.BookMode(
                hingePosition = Rect(),
                hingeSeparationRatio = 0.5f,
                isSeparating = false,
                occlusionType = FoldingFeature.OcclusionType.NONE
            )
        )
    }
}

@Preview(name = "Foldable Table Top Mode", showBackground = true)
@Composable
fun PreviewTableTopMode() {
    SupportAllScreensTheme() {
        DeviceModesScreen(
            screenClassifier = ScreenClassifier.HalfOpened.TableTopMode(
                hingePosition = Rect(),
                hingeSeparationRatio = 0.5f,
                isSeparating = false,
                occlusionType = FoldingFeature.OcclusionType.NONE
            )
        )
    }
}
