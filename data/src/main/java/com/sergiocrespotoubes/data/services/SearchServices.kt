package com.sergiocrespotoubes.data.services

import com.sergiocrespotoubes.data.network.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchServices {
    @GET(value = "/v1/search")
    suspend fun getSearchArtists(
        @Query("type") type: String = "artist",
        @Query("limit") limit: Int = 20,
        @Query("q") artistName: String,
    ): Result<SearchDto>

    @GET(value = "/v1/search")
    suspend fun getSearchTracks(
        @Query("type") type: String = "track",
        @Query("limit") limit: Int = 20,
        @Query("q") artistName: String,
    ): Result<SearchDto>
}
