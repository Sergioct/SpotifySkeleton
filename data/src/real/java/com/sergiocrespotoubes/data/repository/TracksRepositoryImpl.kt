package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.TrackDto
import com.sergiocrespotoubes.data.services.TracksServices

class TracksRepositoryImpl(val tracksServices: TracksServices) : TracksRepository {
    override suspend fun getTracksByArtistId(artistId: String): Result<List<TrackDto>> {
        return tracksServices.getTracksByArtistId(artistId)
    }

    override suspend fun getTrackById(trackId: String): Result<TrackDto> {
        return tracksServices.getTrackById(trackId)
    }
}