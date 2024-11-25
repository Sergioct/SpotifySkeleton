package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistEntity>>>
}
