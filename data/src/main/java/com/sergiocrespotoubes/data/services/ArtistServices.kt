package com.sergiocrespotoubes.data.services

import com.sergiocrespotoubes.data.network.dto.ArtistDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtistServices {
    @GET(value = "/v1/artists/{id}")
    suspend fun getArtistByArtistId(
        @Path("id") artistId: String,
    ): Result<ArtistDto>
}
