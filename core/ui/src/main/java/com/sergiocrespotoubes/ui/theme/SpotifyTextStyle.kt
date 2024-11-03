package com.sergiocrespotoubes.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object SpotifyTextStyle {
    @Composable
    @ReadOnlyComposable
    fun titleBold() =
        TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )

    @Composable
    @ReadOnlyComposable
    fun subtitleBold() =
        TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )

    @Composable
    @ReadOnlyComposable
    fun medium() =
        TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
}
