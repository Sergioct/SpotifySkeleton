package com.sergiocrespotoubes.domain.mapper

import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.network.dto.TrackDto
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import javax.inject.Inject

class ArtistMapper
    @Inject
    constructor() : Mapper<ArtistDto, ArtistModel> {
        override fun toDomainModel(value: ArtistDto): ArtistModel {
            return ArtistModel(
                id = value.id,
                name = value.name,
                popularity = value.popularity,
                urlPicture = value.images.firstOrNull()?.url ?: "",
            )
        }

        override fun toDto(value: ArtistModel): ArtistDto {
            TODO("Not yet implemented")
        }
    }
