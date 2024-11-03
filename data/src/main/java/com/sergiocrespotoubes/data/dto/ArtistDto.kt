package com.sergiocrespotoubes.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArtistDto(
    val id: String,
    val name: String,
    val image: String,
    val genres: List<String>,
    val popularity: Int,
    val followers: Int,
)
