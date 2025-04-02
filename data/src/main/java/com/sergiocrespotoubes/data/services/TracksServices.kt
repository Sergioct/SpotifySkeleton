package com.sergiocrespotoubes.data.services

import com.sergiocrespotoubes.data.network.dto.ArtistTopTracksDto
import com.sergiocrespotoubes.data.network.dto.TrackDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TracksServices {
    @GET(value = "/v1/artists/{id}/top-tracks")
    suspend fun getTracksByArtistId(
        @Path("id") artistId: String,
    ): Result<ArtistTopTracksDto>

    @GET(value = "/v1/tracks/{id}")
    suspend fun getTrackById(
        @Query("id") trackId: String,
    ): Result<TrackDto>
}
