package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.services.SearchServices
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl
    @Inject
    constructor(
        private val searchServices: SearchServices,
    ) : SearchRepository {
        override suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistModel>>> =
            flow {
                emit(
                    Result.success(
                        listOf(
                            ArtistModel(
                                id = "1",
                                name = "Artist 1",
                                popularity = 0,
                                urlPicture = "",
                            ),
                        ),
                    ),
                )
            }

        override suspend fun getSearchByTrack(trackName: String): Flow<Result<List<TrackModel>>> =
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
