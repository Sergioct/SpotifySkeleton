package com.sergiocrespotoubes.domain.usecase.search

import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetSearchByTrackUseCase {
    suspend fun execute(trackName: String): Flow<Result<List<TrackModel>>>
}

class GetSearchByTrackUseCaseImpl
    @Inject
    constructor(
        private val searchRepository: SearchRepository,
    ) : GetSearchByTrackUseCase {
        override suspend fun execute(trackName: String): Flow<Result<List<TrackModel>>> {
            return searchRepository.getSearchByTrack(trackName)
        }
    }
