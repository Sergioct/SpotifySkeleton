package com.sergiocrespotoubes.data.services

import com.sergiocrespotoubes.data.dto.ArtistDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchServices {
    @GET(value = "/v1/search")
    suspend fun getSearchArtistSongs(
        @Query("type") type: String = "artist",
        @Query("limit") limit: Int = 1,
        @Query("artist_name") artistName: String,
    ): Result<ArtistDto>
}