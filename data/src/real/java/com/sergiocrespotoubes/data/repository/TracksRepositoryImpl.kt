package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.mapper.toModel
import com.sergiocrespotoubes.data.services.TracksServices
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TracksRepositoryImpl @Inject constructor(
    private val tracksServices: TracksServices
) : TracksRepository {
    override suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackModel>>> =
        flow {
            emit(tracksServices.getTracksByArtistId(artistId).map { tracksDto ->
                tracksDto.map { it.toModel() }
            })
        }

    override suspend fun getTrackById(trackId: String): Flow<Result<TrackModel>> =
        flow {
            emit(tracksServices.getTrackById(trackId).map { trackDto ->
                trackDto.toModel()
            })
        }
}
