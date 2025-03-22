package com.sergiocrespotoubes.ui.components.async

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

@Composable
fun SpotifyImage(
    modifier: Modifier = Modifier,
    painter: ImageVector,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Fit,
    color: Color? = null,
) {
    Image(
        modifier = modifier,
        imageVector = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = color?.let { ColorFilter.tint(it) },
    )
}

@Composable
fun SpotifyImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Fit,
    color: Color? = null,
) {
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = color?.let { ColorFilter.tint(it) },
    )
}

@Composable
fun SpotifyImage(
    modifier: Modifier = Modifier,
    painter: ImageBitmap,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Fit,
    color: Color? = null,
) {
    Image(
        modifier = modifier,
        bitmap = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = color?.let { ColorFilter.tint(it) },
    )
}
