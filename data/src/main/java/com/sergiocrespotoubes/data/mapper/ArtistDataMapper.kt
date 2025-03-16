package com.sergiocrespotoubes.data.mapper

import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.domain.model.ArtistModel

fun ArtistDto.toArtistEntity(): ArtistEntity {
    return ArtistEntity(
        id = this.id,
        name = this.name,
        image = this.images.firstOrNull()?.url ?: "",
        popularity = this.popularity,
    )
}

fun ArtistEntity.toTrackModel(): ArtistModel {
    return ArtistModel(
        id = this.id,
        name = this.name,
        urlPicture = this.image,
        popularity = this.popularity,
    )
}

fun ArtistDto.toTrackModel(): ArtistModel {
    return ArtistModel(
        id = this.id,
        name = this.name,
        urlPicture = this.images.firstOrNull()?.url ?: "",
        popularity = this.popularity,
    )
}
