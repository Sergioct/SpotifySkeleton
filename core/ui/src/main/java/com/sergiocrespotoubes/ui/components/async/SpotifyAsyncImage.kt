package com.sergiocrespotoubes.ui.components.async

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun SpotifyAsyncImage(
    modifier: Modifier = Modifier,
    model: Any?,
    placeholder: Painter? = null,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Fit,
    error: Painter? = null,
    color: Color? = null,
) {
    AsyncImage(
        modifier = modifier,
        model = model,
        placeholder = placeholder,
        contentDescription = contentDescription,
        contentScale = contentScale,
        error = error,
        colorFilter = color?.let { ColorFilter.tint(it) },
    )
}
