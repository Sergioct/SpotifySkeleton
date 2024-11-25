package com.sergiocrespotoubes.domain.mapper

import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.network.dto.TrackDto
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import javax.inject.Inject

class ArtistMapper
    @Inject
    constructor() : Mapper<ArtistEntity, ArtistModel> {
        override fun toDomainModel(value: ArtistEntity): ArtistModel {
            return ArtistModel(
                id = value.id,
                name = value.name,
                popularity = value.popularity,
                urlPicture = value.image,
            )
        }

        override fun toDto(value: ArtistModel): ArtistEntity {
            TODO("Not yet implemented")
        }
    }
