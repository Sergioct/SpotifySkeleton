package com.sergiocrespotoubes.data.network.datasource

import com.sergiocrespotoubes.data.network.dto.SearchDto
import com.sergiocrespotoubes.data.services.SearchServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface SearchNetworkDataSource {
    suspend fun getSearchArtistSongs(artistName: String): Flow<SearchDto>
}

@Singleton
class SearchNetworkDataSourceImpl @Inject constructor(
    private val searchServices: SearchServices,
) : SearchNetworkDataSource {
    override suspend fun getSearchArtistSongs(artistName: String): Flow<SearchDto> = flow {
        searchServices.getSearchArtistSongs(artistName = artistName)
    }
}