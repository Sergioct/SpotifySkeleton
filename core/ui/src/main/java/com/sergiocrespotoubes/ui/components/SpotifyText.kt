package com.sergiocrespotoubes.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sergiocrespotoubes.ui.theme.SpotifyTextStyle

@Composable
fun SpotifyTextTitleBold(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.titleBold(),
    )
}

@Composable
fun SpotifyTextSubtitleBold(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.subtitleBold(),
    )
}

@Composable
fun SpotifyTextMedium(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.medium(),
        maxLines = maxLines,
    )
}

@Composable
fun SpotifyTextSmall(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.small(),
        maxLines = maxLines,
    )
}
