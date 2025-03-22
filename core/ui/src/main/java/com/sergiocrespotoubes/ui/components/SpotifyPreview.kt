package com.sergiocrespotoubes.ui.components

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark

@SpotifyBasePreview
@SpotifyUiPreview
@SpotifyScalePreviews
@SpotifyFullPreview
annotation class SpotifyPreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
)
annotation class SpotifyBasePreview

@PreviewLightDark
annotation class SpotifyUiPreview

@Preview(name = "Full Preview", showSystemUi = true)
annotation class SpotifyFullPreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light",
    group = "Ui mode",
)
annotation class LightModePreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark",
    group = "Ui mode",
)
annotation class DarkModePreview

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    name = "Normal",
    group = "Font scales",
    fontScale = 1f,
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    name = "Large",
    group = "Font scales",
    fontScale = 2f,
)
annotation class SpotifyScalePreviews
