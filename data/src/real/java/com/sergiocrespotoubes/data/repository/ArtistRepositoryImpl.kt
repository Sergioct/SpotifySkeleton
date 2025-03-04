package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.mapper.toTrackModel
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.ArtistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistRepositoryImpl
    @Inject
    constructor(
        private val artistsDbDatasource: ArtistsDbDatasource,
    ) : ArtistRepository {
        override suspend fun getArtistsFromDb(): Flow<Result<List<ArtistModel>>> =
            flow {
                val artistsFlow =
                    artistsDbDatasource.getArtists().map { artists ->
                        Result.success(artists.map { it.toTrackModel() })
                    }
                emitAll(artistsFlow)
            }
    }
