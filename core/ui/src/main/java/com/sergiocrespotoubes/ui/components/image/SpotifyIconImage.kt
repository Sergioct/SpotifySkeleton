package com.sergiocrespotoubes.ui.components.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

@Composable
fun SpotifyIconImage(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Fit,
    color: Color? = null,
) {
    Image(
        modifier = modifier,
        imageVector = imageVector,
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = color?.let { ColorFilter.tint(it) },
    )
}
