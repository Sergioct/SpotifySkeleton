package com.sergiocrespotoubes.domain.repository

import com.sergiocrespotoubes.domain.model.ArtistModel
import kotlinx.coroutines.flow.Flow

interface ArtistRepository {
    suspend fun getArtistsFromDb(): Flow<Result<List<ArtistModel>>>

    suspend fun getArtistByArtistId(artistId: String): Flow<Result<ArtistModel>>
}
