package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.datasource.TracksDbDataSource
import com.sergiocrespotoubes.data.mapper.toTrackModel
import com.sergiocrespotoubes.data.services.TracksServices
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TracksRepositoryImpl
    @Inject
    constructor(
        private val tracksServices: TracksServices,
        private val tracksDbDatasource: TracksDbDataSource,
    ) : TracksRepository {
        override suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackModel>>> =
            flow {
                emit(
                    tracksServices.getTracksByArtistId(artistId).map { artistTopTracksDto ->
                        artistTopTracksDto.tracks.map { it.toTrackModel() }
                    },
                )
            }

        override suspend fun getTrackById(trackId: String): Flow<Result<TrackModel>> =
            flow {
                emit(
                    tracksServices.getTrackById(trackId).map { trackDto ->
                        trackDto.toTrackModel()
                    },
                )
            }

        override suspend fun getTracksFromDb(): Flow<Result<List<TrackModel>>> =
            flow {
                val tracksFlow =
                    tracksDbDatasource.getTracks().map { artists ->
                        Result.success(artists.map { it.toTrackModel() })
                    }
                emitAll(tracksFlow)
            }
    }
