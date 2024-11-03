package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.TrackDto
import kotlinx.coroutines.flow.Flow

interface TracksRepository {
    suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackDto>>>
    suspend fun getTrackById(trackId: String): Flow<Result<TrackDto>>
}