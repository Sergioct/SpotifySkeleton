package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.ArtistDto
import com.sergiocrespotoubes.data.services.SearchServices

class SearchRepositoryImpl(private val searchServices: SearchServices) : SearchRepository {
    override suspend fun getSearchArtistSongs(artistName: String): Result<ArtistDto> {
        return searchServices.getSearchArtistSongs(artistName = artistName)
    }
}