package com.sergiocrespotoubes.ui.components

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SpotifyButton(
    modifier: Modifier = Modifier,
    text: String,
    onCLick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onCLick,
    ) {
        SpotifyTextMedium(text = text)
    }
}
