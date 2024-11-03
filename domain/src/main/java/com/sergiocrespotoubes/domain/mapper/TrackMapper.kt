package com.sergiocrespotoubes.domain.mapper

import com.sergiocrespotoubes.data.dto.TrackDto
import com.sergiocrespotoubes.domain.model.TrackModel
import javax.inject.Inject

class TrackMapper
    @Inject
    constructor() : Mapper<TrackDto, TrackModel> {
        override fun toDomainModel(value: TrackDto): TrackModel {
            return TrackModel(
                id = value.id,
                name = value.name,
            )
        }

        override fun toDto(value: TrackModel): TrackDto {
            TODO("Not yet implemented")
        }
    }
