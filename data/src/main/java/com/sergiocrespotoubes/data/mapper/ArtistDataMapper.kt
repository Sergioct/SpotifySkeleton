package com.sergiocrespotoubes.data.mapper

import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import com.sergiocrespotoubes.data.network.dto.ArtistDto

fun ArtistDto.toArtistEntity(): ArtistEntity {
    return ArtistEntity(
        id = this.id,
        name = this.name,
        image = this.images.firstOrNull()?.url ?: "",
        popularity = this.popularity,
    )
}