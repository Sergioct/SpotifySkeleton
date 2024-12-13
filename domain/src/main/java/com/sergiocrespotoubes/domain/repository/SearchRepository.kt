package com.sergiocrespotoubes.domain.repository

import com.sergiocrespotoubes.domain.model.ArtistModel
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistModel>>>
}
