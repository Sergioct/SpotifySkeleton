package com.sergiocrespotoubes.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable

@Composable
fun SpotifySpinnerLoading(
    isVisible: Boolean
) {
    if (isVisible) {
        CircularProgressIndicator()
    }
}