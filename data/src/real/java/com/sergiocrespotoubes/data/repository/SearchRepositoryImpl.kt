package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.common.SpotifyLog
import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.mapper.toArtistEntity
import com.sergiocrespotoubes.data.mapper.toArtistModel
import com.sergiocrespotoubes.data.network.datasource.SearchNetworkDataSource
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val artistsDbDatasource: ArtistsDbDatasource,
    private val searchNetworkDataSource: SearchNetworkDataSource,
) : SearchRepository {

    override suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistModel>>> = flow {
        merge(
            readArtistsFromDb(),
            readArtistsFromNetwork(artistName)
        ).collect { result ->
            emit(result)
        }
    }

    private fun readArtistsFromNetwork(
        artistName: String
    ) = flow {
        SpotifyLog.i("readArtistsFromNetwork $artistName")
        searchNetworkDataSource.getSearchArtists(artistName)
            .map { searchDto ->
                SpotifyLog.i("readArtistsFromNetwork result $searchDto ${searchDto.artists.items.size}")
                searchDto.artists.items.map { artistDto ->
                    artistDto.toArtistEntity()
                }
            }.map { artistsEntity ->
                SpotifyLog.i("readArtistsFromNetwork saveArtists $artistsEntity")
                artistsDbDatasource.clearAll()
                artistsDbDatasource.saveArtists(artistsEntity)
                emitAll(readArtistsFromDb())
            }
    }.flowOn(Dispatchers.IO)

    private fun readArtistsFromDb() = flow {
        SpotifyLog.i("readArtistsFromDb")
        val artistsFlow = artistsDbDatasource.getArtists().map {
            Result.success(it.map { artistsEntity ->
                artistsEntity.toArtistModel()
            })
        }
        emitAll(artistsFlow)
    }.flowOn(Dispatchers.IO)
}