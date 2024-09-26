package com.sergiocrespotoubes.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import com.sergiocrespotoubes.ui.R

object SpotifyDimen {
    @Composable
    @ReadOnlyComposable
    fun spaceSmall() = dimensionResource(R.dimen.space_small)

    @Composable
    @ReadOnlyComposable
    fun spaceMedium() = dimensionResource(R.dimen.space_medium)

    @Composable
    @ReadOnlyComposable
    fun spaceBig() = dimensionResource(R.dimen.space_big)
}