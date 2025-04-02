package com.sergiocrespotoubes.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArtistTopTracksDto(
    val tracks: List<TrackDto>,
)
