package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.TrackDto

interface TracksRepository {
    suspend fun getTracksByArtistId(artistId: String): Result<List<TrackDto>>
    suspend fun getTrackById(trackId: String): Result<TrackDto>
}