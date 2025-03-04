package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.services.TracksServices
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TracksRepositoryImpl
    @Inject
    constructor(
        val tracksServices: TracksServices,
    ) : TracksRepository {
        override suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackModel>>> =
            flow {
                emit(
                    Result.success(
                        listOf(
                            TrackModel(
                                id = "1",
                                name = "Artist 1",
                                popularity = 0,
                                urlPicture = "",
                            ),
                        ),
                    ),
                )
            }

        override suspend fun getTrackById(trackId: String): Flow<Result<TrackModel>> =
            flow {
                emit(
                    Result.success(
                        TrackModel(
                            id = "1",
                            name = "Artist 1",
                            popularity = 0,
                            urlPicture = "",
                        ),
                    ),
                )
            }

        override suspend fun getTracksFromDb(): Flow<Result<List<TrackModel>>> =
            flow {
                emit(
                    Result.success(
                        listOf(
                            TrackModel(
                                id = "1",
                                name = "Artist 1",
                                popularity = 0,
                                urlPicture = "",
                            ),
                        ),
                    ),
                )
            }
    }
