package com.sergiocrespotoubes.domain.usecase.tracks

import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetTrackByIdUseCase {
    suspend fun execute(trackId: String): Flow<Result<TrackModel>>
}

class GetTrackByIdUseCaseImpl
    @Inject
    constructor(
        private val tracksRepository: TracksRepository,
    ) : GetTrackByIdUseCase {
        override suspend fun execute(trackId: String): Flow<Result<TrackModel>> {
            return tracksRepository.getTrackById(trackId)
        }
    }
