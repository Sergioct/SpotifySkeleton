package com.sergiocrespotoubes.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object Splash

    @Serializable
    object ArtistSearch

    @Serializable
    data class TrackDetail(
        val trackId: String,
    )

    @Serializable
    data class ArtistDetail(
        val artistId: String,
    )
}
