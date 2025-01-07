package com.sergiocrespotoubes.domain.repository

import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchByArtist(artistName: String): Flow<Result<List<ArtistModel>>>
    suspend fun getSearchByTrack(trackName: String): Flow<Result<List<TrackModel>>>
}
