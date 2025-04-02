package com.sergiocrespotoubes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme =
    darkColorScheme(
        primary = SpotifyThemeColors.Dark.primary,
        secondary = SpotifyThemeColors.Dark.secondary,
        background = SpotifyThemeColors.Dark.background,
        surface = SpotifyThemeColors.Dark.surface,
        onPrimary = SpotifyThemeColors.Dark.textPrimary,
        onSecondary = SpotifyThemeColors.Dark.textSecondary,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = SpotifyThemeColors.Light.primary,
        secondary = SpotifyThemeColors.Light.secondary,
        background = SpotifyThemeColors.Light.background,
        surface = SpotifyThemeColors.Light.surface,
        onPrimary = SpotifyThemeColors.Light.textPrimary,
        onSecondary = SpotifyThemeColors.Light.textSecondary,
    )

@Composable
fun SpotifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}
