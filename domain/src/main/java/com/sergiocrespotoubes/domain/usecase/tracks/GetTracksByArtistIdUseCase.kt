package com.sergiocrespotoubes.domain.usecase.tracks

import com.sergiocrespotoubes.data.repository.TracksRepository
import com.sergiocrespotoubes.domain.mapper.TrackMapper
import com.sergiocrespotoubes.domain.model.TrackModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetTracksByArtistIdUseCase {
    suspend fun execute(artistId: String): Flow<Result<List<TrackModel>>>
}

class GetTracksByArtistIdUseCaseImpl
    @Inject
    constructor(
        private val tracksRepository: TracksRepository,
        private val trackMapper: TrackMapper,
    ) : GetTracksByArtistIdUseCase {
        override suspend fun execute(artistId: String): Flow<Result<List<TrackModel>>> {
            return tracksRepository.getTracksByArtistId(artistId).map { response ->
                response.map { tracksList ->
                    tracksList.map { trackDto ->
                        trackMapper.toDomainModel(trackDto)
                    }
                }
            }
        }
    }
