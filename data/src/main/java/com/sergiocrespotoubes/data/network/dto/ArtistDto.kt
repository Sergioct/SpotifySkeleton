package com.sergiocrespotoubes.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArtistDto(
    val id: String,
    val name: String,
    val popularity: Int,
    val images: List<ImageDto> = emptyList()
) {
}
