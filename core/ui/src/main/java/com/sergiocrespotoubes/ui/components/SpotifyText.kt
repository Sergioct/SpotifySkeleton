package com.sergiocrespotoubes.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.sergiocrespotoubes.ui.theme.SpotifyTextStyle

@Composable
fun SpotifyTextTitleBold(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.titleBold(),
        maxLines = maxLines,
    )
}

@Composable
fun SpotifyTextSubtitleBold(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.subtitleBold(),
        maxLines = maxLines,
    )
}

@Composable
fun SpotifyTextBig(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.big(),
        maxLines = maxLines,
        textAlign = textAlign,
    )
}

@Composable
fun SpotifyTextMedium(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        modifier = modifier,
        text = text,
        style = SpotifyTextStyle.medium(),
        maxLines = maxLines,
        textAlign = textAlign,
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
