package com.sergiocrespotoubes.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sergiocrespotoubes.ui.components.SpotifyTextMedium

@Composable
fun SpotifyButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        SpotifyTextMedium(text = text)
    }
}
