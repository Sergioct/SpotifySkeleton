package com.sergiocrespotoubes.data.network.datasource

import com.sergiocrespotoubes.data.network.dto.SearchDto
import com.sergiocrespotoubes.data.services.SearchServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ArtistsNetworkDatasource {
    suspend fun getSearchArtistSongs(artistName: String): Flow<SearchDto>
}

class ArtistsNetworkDatasourceImpl(
    private val searchServices: SearchServices,
) : ArtistsNetworkDatasource {
    override suspend fun getSearchArtistSongs(artistName: String): Flow<SearchDto> = flow {
        searchServices.getSearchArtistSongs(artistName = artistName)
    }
}