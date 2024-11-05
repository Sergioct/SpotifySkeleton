package com.sergiocrespotoubes.data.services

import com.sergiocrespotoubes.data.network.dto.TrackDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TracksServices {
    @GET(value = "/api/token")
    suspend fun getTracksByArtistId(
        @Query("artist_id") artistId: String,
        @Query("type") type: String = "artist",
        @Query("limit") limit: Int = 1,
    ): Result<List<TrackDto>>

    @GET(value = "/api/token")
    suspend fun getTrackById(
        @Query("track_id") trackId: String,
    ): Result<TrackDto>
}
