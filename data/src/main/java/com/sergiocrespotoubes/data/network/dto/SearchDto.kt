package com.sergiocrespotoubes.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchDto(
    val artists: ArtistsListDto? = null,
    val tracks: TracksListDto? = null,
) {
}