package com.sergiocrespotoubes.ui.components

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@SpotifyBasePreview
@SpotifyUiPreview
@SpotifyScalePreviews
annotation class SpotifyPreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
)
annotation class SpotifyBasePreview

@LightModePreview
@DarkModePreview
annotation class SpotifyUiPreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
annotation class LightModePreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark ui mode",
    group = "Ui mode",
)
annotation class DarkModePreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    name = "Normal font",
    group = "Font scales",
    fontScale = 1f,
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    name = "Large font",
    group = "Font scales",
    fontScale = 2f,
)
annotation class SpotifyScalePreviews
