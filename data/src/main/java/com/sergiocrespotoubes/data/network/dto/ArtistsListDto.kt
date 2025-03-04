package com.sergiocrespotoubes.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArtistsListDto(
    val items: List<ArtistDto> = emptyList(),
)
