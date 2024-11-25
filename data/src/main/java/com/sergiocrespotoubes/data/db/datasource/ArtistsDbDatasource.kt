package com.sergiocrespotoubes.data.db.datasource

import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import kotlinx.coroutines.flow.Flow

interface ArtistsDbDatasource {
    suspend fun getArtists(): Flow<List<ArtistEntity>>
}

class ArtistsDbDatasourceImpl(
    private val artistDao: ArtistDao,
) : ArtistsDbDatasource {
    override suspend fun getArtists(): Flow<List<ArtistEntity>> {
        return artistDao.getArtists()
    }
}