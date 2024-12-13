package com.sergiocrespotoubes.data.db.datasource

import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface ArtistsDbDatasource {
    suspend fun getArtists(): Flow<List<ArtistEntity>>
    fun saveArtists(artists: List<ArtistEntity>)
}

@Singleton
class ArtistsDbDatasourceImpl @Inject constructor(
    private val artistDao: ArtistDao,
) : ArtistsDbDatasource {
    override suspend fun getArtists(): Flow<List<ArtistEntity>> {
        return artistDao.getArtists()
    }

    override fun saveArtists(artists: List<ArtistEntity>) {
        artistDao.insertArtists(artists)
    }
}