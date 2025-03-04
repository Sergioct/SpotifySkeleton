package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.mapper.toArtistEntity
import com.sergiocrespotoubes.data.mapper.toArtistModel
import com.sergiocrespotoubes.data.network.datasource.ArtistNetworkDataSource
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.ArtistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistRepositoryImpl
    @Inject
    constructor(
        private val artistsDbDatasource: ArtistsDbDatasource,
        private val artistNetworkDataSource: ArtistNetworkDataSource,
    ) : ArtistRepository {
        override suspend fun getArtistsFromDb(): Flow<Result<List<ArtistModel>>> =
            flow {
                val artistsFlow =
                    artistsDbDatasource.getArtists().map { artists ->
                        Result.success(artists.map { it.toArtistModel() })
                    }
                emitAll(artistsFlow)
            }

        override suspend fun getArtistByArtistId(artistId: String): Flow<Result<ArtistModel>> =
            flow {
                artistNetworkDataSource.getArtistByArtistId(artistId)
                    .map { artistDto ->
                        artistDto.toArtistEntity()
                    }.map { artistsEntity ->
                        artistsDbDatasource.insertArtist(artistsEntity)
                        emit(Result.success(artistsEntity.toArtistModel()))
                    }
            }.flowOn(Dispatchers.IO)
    }
