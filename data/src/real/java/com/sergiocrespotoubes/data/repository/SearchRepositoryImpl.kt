package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import com.sergiocrespotoubes.data.mapper.toArtistEntity
import com.sergiocrespotoubes.data.network.datasource.SearchNetworkDataSource
import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.network.dto.SearchDto
import com.sergiocrespotoubes.data.services.SearchServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val artistsDbDatasource: ArtistsDbDatasource,
    private val searchNetworkDataSource: SearchNetworkDataSource,
) : SearchRepository {
    override suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistEntity>>> = flow {
        try {
            val artistsFromDb = artistsDbDatasource.getArtists()
            artistsFromDb.collect { artists ->
                if (artists.isNotEmpty()) {
                    emit(Result.success(artists))
                }
            }

            val searchResult = searchNetworkDataSource.getSearchArtistSongs(artistName)
            searchResult.collect { searchDto ->
                val artists = searchDto.artists.items.map { artistDto ->
                    artistDto.toArtistEntity()
                }
                artistsDbDatasource.saveArtists(artists)
                emit(Result.success(artists))
            }
        } catch (e: Exception) {
            val artistsFromDb = artistsDbDatasource.getArtists()
            artistsFromDb.collect { artists ->
                if (artists.isNotEmpty()) {
                    emit(Result.success(artists))
                } else {
                    emit(Result.failure(e))
                }
            }
        }
    }
}
