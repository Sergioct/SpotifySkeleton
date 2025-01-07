package com.sergiocrespotoubes.data.mapper

import com.sergiocrespotoubes.data.db.entities.TrackEntity
import com.sergiocrespotoubes.data.network.dto.TrackDto
import com.sergiocrespotoubes.domain.model.TrackModel

fun TrackDto.toTrackEntity(): TrackEntity {
    return TrackEntity(
        id = this.id,
        name = this.name,
        image = this.album.images.firstOrNull()?.url ?: "",
        popularity = this.popularity,
    )
}

fun TrackEntity.toTrackModel(): TrackModel {
    return TrackModel(
        id = this.id,
        name = this.name,
        urlPicture = this.image,
        popularity = this.popularity,
    )
}

fun TrackDto.toTrackModel(): TrackModel {
    return TrackModel(
        id = this.id,
        name = this.name,
        urlPicture = this.album.images.firstOrNull()?.url ?: "",
        popularity = this.popularity,
    )
}