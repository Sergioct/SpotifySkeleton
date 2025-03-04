package com.sergiocrespotoubes.data.db.datasource

import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface ArtistsDbDatasource {
    fun getArtists(): Flow<List<ArtistEntity>>

    suspend fun saveArtists(artists: List<ArtistEntity>)

    suspend fun insertArtist(artist: ArtistEntity)

    suspend fun clearAll()
}

@Singleton
class ArtistsDbDatasourceImpl
    @Inject
    constructor(
        private val artistDao: ArtistDao,
    ) : ArtistsDbDatasource {
        override fun getArtists(): Flow<List<ArtistEntity>> {
            return artistDao.getArtists()
        }

        override suspend fun saveArtists(artists: List<ArtistEntity>) {
            artistDao.insertArtists(artists)
        }

        override suspend fun insertArtist(artist: ArtistEntity) {
            artistDao.insertArtist(artist)
        }

        override suspend fun clearAll() {
            artistDao.clearAll()
        }
    }
