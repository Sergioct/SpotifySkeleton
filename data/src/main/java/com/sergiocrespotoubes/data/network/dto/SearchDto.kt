package com.sergiocrespotoubes.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchDto(
    val artists: ArtistsListDto?,
    val tracks: TracksListDto?,
) {
}