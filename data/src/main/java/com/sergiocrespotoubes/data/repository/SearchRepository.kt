package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.ArtistDto
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchArtistSongs(artistName: String): Flow<Result<ArtistDto>>
}
