package com.sergiocrespotoubes.domain.repository

import com.sergiocrespotoubes.domain.model.TrackModel
import kotlinx.coroutines.flow.Flow

interface TracksRepository {
    suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackModel>>>

    suspend fun getTrackById(trackId: String): Flow<Result<TrackModel>>
}
