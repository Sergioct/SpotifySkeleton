package com.sergiocrespotoubes.data.mapper

import com.sergiocrespotoubes.data.network.dto.TrackDto
import com.sergiocrespotoubes.domain.model.TrackModel

fun TrackDto.toModel(): TrackModel {
    return TrackModel(
        id = this.id,
        name = this.name,
    )
}