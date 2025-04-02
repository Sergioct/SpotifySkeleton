package com.sergiocrespotoubes.domain.usecase.tracks

import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetTracksByArtistIdUseCase {
    suspend fun execute(artistId: String): Flow<Result<List<TrackModel>>>
}

class GetTracksByArtistIdUseCaseImpl
    @Inject
    constructor(
        private val tracksRepository: TracksRepository,
    ) : GetTracksByArtistIdUseCase {
        override suspend fun execute(artistId: String): Flow<Result<List<TrackModel>>> {
            return tracksRepository.getTracksByArtistId(artistId)
        }
    }
