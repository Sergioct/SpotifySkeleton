package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import com.sergiocrespotoubes.data.mapper.toArtistEntity
import com.sergiocrespotoubes.data.mapper.toArtistModel
import com.sergiocrespotoubes.data.network.datasource.SearchNetworkDataSource
import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.network.dto.SearchDto
import com.sergiocrespotoubes.data.services.SearchServices
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val artistsDbDatasource: ArtistsDbDatasource,
    private val searchNetworkDataSource: SearchNetworkDataSource,
) : SearchRepository {

    override suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistModel>>> = flow {
        readArtistsFromDb()
        readArtistsFromNetwork(artistName)
    }

    private suspend fun FlowCollector<Result<List<ArtistModel>>>.readArtistsFromNetwork(
        artistName: String
    ) {
        searchNetworkDataSource.getSearchArtistSongs(artistName)
            .map { searchDto ->
                searchDto.artists.items.map { artistDto ->
                    artistDto.toArtistEntity()
                }
            }.map { artistsEntity ->
                artistsDbDatasource.saveArtists(artistsEntity)
            }.map {
                readArtistsFromDb()
            }.catch { readArtistsFromDb() }
    }

    private suspend fun FlowCollector<Result<List<ArtistModel>>>.readArtistsFromDb() {
        artistsDbDatasource.getArtists()
            .map { artistsDto ->
                artistsDto.map { artistDto ->
                    artistDto.toArtistModel()
                }
            }.map { artistsModel ->
                emit(Result.success(artistsModel))
            }
    }
}