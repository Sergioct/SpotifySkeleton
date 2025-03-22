package com.sergiocrespotoubes.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
sealed class SpotifyThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val secondary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
) {
    data object Light : SpotifyThemeColors(
        background = backgroundLight,
        surface = surfaceLight,
        primary = primaryLight,
        secondary = secondaryLight,
        textPrimary = textPrimaryLight,
        textSecondary = textSecondaryLight,
    )

    data object Dark : SpotifyThemeColors(
        background = backgroundDark,
        surface = surfaceDark,
        primary = primaryDark,
        secondary = secondaryDark,
        textPrimary = textPrimaryDark,
        textSecondary = textSecondaryDark,
    )
}
