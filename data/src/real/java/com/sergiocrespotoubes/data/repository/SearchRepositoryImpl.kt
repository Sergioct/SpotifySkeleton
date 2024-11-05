package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.services.SearchServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val searchServices: SearchServices,
    private val artistDao: ArtistDao,
    private val trackDao: TrackDao,
    //private val albumDao: AlbumDao,
) : SearchRepository {
    override suspend fun getSearchArtistSongs(artistName: String): Flow<Result<ArtistDto>> = flow {
        val artistsFromDb = artistDao.getArtists()
        emit(Result.success(artistsFromDb))
        emit(searchServices.getSearchArtistSongs(artistName = artistName))
    }
}
