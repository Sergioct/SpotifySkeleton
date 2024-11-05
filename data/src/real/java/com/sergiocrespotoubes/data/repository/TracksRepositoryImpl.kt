package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.TrackDto
import com.sergiocrespotoubes.data.services.TracksServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TracksRepositoryImpl @Inject constructor(
    private val tracksServices: TracksServices
) : TracksRepository {
    override suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackDto>>> =
        flow {
            emit(tracksServices.getTracksByArtistId(artistId))
        }

    override suspend fun getTrackById(trackId: String): Flow<Result<TrackDto>> =
        flow {
            emit(tracksServices.getTrackById(trackId))
        }
}
