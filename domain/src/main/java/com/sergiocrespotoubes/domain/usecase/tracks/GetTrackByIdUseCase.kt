package com.sergiocrespotoubes.domain.usecase.tracks

import com.sergiocrespotoubes.data.repository.TracksRepository
import com.sergiocrespotoubes.domain.mapper.TrackMapper
import com.sergiocrespotoubes.domain.model.TrackModel
import javax.inject.Inject

interface GetTrackByIdUseCase {
    suspend fun execute(trackId: String): Result<TrackModel>
}

class GetTrackByIdUseCaseImpl @Inject constructor(
    private val tracksRepository: TracksRepository,
    private val trackMapper: TrackMapper
): GetTrackByIdUseCase {
    override suspend fun execute(trackId: String): Result<TrackModel> {
        return tracksRepository.getTrackById(trackId).map { trackDto ->
            trackMapper.toDomainModel(trackDto)
        }
    }
}