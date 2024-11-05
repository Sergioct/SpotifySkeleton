package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.ArtistDto
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchArtistSongs(artistName: String): Flow<Result<ArtistDto>>
}
