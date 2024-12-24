package com.sergiocrespotoubes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotifyToolbar(title: String) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = SpotifyTheme().color.teal200),
        title = {
        SpotifyTextMedium(
            text = title,
            maxLines = 1,
        )
    })
}