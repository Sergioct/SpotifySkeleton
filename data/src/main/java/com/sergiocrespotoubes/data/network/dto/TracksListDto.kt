package com.sergiocrespotoubes.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class TracksListDto(
    val items: List<TrackDto> = emptyList(),
)
