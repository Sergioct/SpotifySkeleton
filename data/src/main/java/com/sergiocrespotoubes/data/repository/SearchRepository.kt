package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.ArtistDto

interface SearchRepository {
    suspend fun getSearchArtistSongs(artistName: String): Result<ArtistDto>
}