package com.sergiocrespotoubes.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TrackDto(
    val id: String,
    val name: String,
    val duration: Int,
    val artistId: String,
    val albumId: String,
    val previewUrl: String,
    val imageUrl: String,
    val isFavorite: Boolean,
)