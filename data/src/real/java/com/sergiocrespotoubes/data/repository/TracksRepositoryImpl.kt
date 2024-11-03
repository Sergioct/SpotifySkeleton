package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.TrackDto
import com.sergiocrespotoubes.data.services.TracksServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TracksRepositoryImpl(private val tracksServices: TracksServices) : TracksRepository {
    override suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackDto>>> =
        flow {
            emit(tracksServices.getTracksByArtistId(artistId))
        }

    override suspend fun getTrackById(trackId: String): Flow<Result<TrackDto>> =
        flow {
            emit(tracksServices.getTrackById(trackId))
        }
}
