package com.sergiocrespotoubes.data.network.datasource

import com.sergiocrespotoubes.common.SpotifyLog
import com.sergiocrespotoubes.data.network.dto.SearchDto
import com.sergiocrespotoubes.data.services.SearchServices
import javax.inject.Inject
import javax.inject.Singleton

interface SearchNetworkDataSource {
    suspend fun getSearchArtists(artistName: String): Result<SearchDto>

    suspend fun getSearchTracks(trackName: String): Result<SearchDto>
}

@Singleton
class SearchNetworkDataSourceImpl
    @Inject
    constructor(
        private val searchServices: SearchServices,
    ) : SearchNetworkDataSource {
        override suspend fun getSearchArtists(artistName: String): Result<SearchDto> {
            SpotifyLog.i("SearchNetworkDataSourceImpl getSearchArtistSongs $artistName")
            val result = searchServices.getSearchArtists(artistName = artistName)
            SpotifyLog.i("SearchNetworkDataSourceImpl getSearchArtistSongs 2 $result")
            return result
        }

        override suspend fun getSearchTracks(trackName: String): Result<SearchDto> {
            SpotifyLog.i("SearchNetworkDataSourceImpl getSearchArtistSongs $trackName")
            return searchServices.getSearchArtists(artistName = trackName)
        }
    }
