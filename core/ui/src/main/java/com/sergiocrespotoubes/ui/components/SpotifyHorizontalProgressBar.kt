package com.sergiocrespotoubes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun SpotifyHorizontalProgressBar(isVisible: Boolean) {
    LinearProgressIndicator(
        modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .graphicsLayer {
                    alpha = if (isVisible) 1f else 0f
                },
    )
}
