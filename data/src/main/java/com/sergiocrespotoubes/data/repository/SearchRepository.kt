package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.SearchDto
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchByArtist(artistName: String): Flow<Result<List<SearchDto>>>
}
