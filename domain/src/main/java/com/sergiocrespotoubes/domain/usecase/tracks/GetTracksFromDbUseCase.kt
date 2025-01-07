package com.sergiocrespotoubes.domain.usecase.tracks

import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetTracksFromDbUseCase {
    suspend fun execute(): Flow<Result<List<TrackModel>>>
}

class GetTracksFromDbUseCaseImpl @Inject constructor(
    private val tracksRepository: TracksRepository,
) : GetTracksFromDbUseCase {
    override suspend fun execute(): Flow<Result<List<TrackModel>>> {
        return tracksRepository.getTracksFromDb()
    }
}
