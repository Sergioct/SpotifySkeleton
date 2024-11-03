package com.sergiocrespotoubes.domain.usecase.tracks

import com.sergiocrespotoubes.data.repository.TracksRepository
import com.sergiocrespotoubes.domain.mapper.TrackMapper
import com.sergiocrespotoubes.domain.model.TrackModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetTrackByIdUseCase {
    suspend fun execute(trackId: String): Flow<Result<TrackModel>>
}

class GetTrackByIdUseCaseImpl @Inject constructor(
    private val tracksRepository: TracksRepository,
    private val trackMapper: TrackMapper
): GetTrackByIdUseCase {
    override suspend fun execute(trackId: String): Flow<Result<TrackModel>> {
        return tracksRepository.getTrackById(trackId).map { response ->
            response.map { trackDto ->
                trackMapper.toDomainModel(trackDto)
            }
        }
    }
}