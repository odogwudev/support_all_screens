package com.odogwudev.supportallscreens.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odogwudev.supportallscreens.ui.theme.SupportAllScreensTheme
import com.odogwudev.supportallscreens.R

@Composable
fun HomeScreen(
    onDeviceModeButtonTap: () -> Unit,
    onLayoutModeButtonTap: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Button(
                onClick = onDeviceModeButtonTap
            ) {
                Text(text = stringResource(id = R.string.view_device_modes))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onLayoutModeButtonTap
            ) {
                Text(text = stringResource(id = R.string.view_layout_modes))
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    name = "Full Preview"
)
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "Light Mode"
)
@Composable
fun HomeScreenPreview() {
    SupportAllScreensTheme() {
        HomeScreen(
            onDeviceModeButtonTap = {},
            onLayoutModeButtonTap = {}
        )
    }
}
