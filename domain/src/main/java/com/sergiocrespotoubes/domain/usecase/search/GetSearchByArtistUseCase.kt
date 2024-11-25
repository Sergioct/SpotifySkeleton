package com.sergiocrespotoubes.domain.usecase.search

import com.sergiocrespotoubes.data.repository.SearchRepository
import com.sergiocrespotoubes.domain.mapper.ArtistMapper
import com.sergiocrespotoubes.domain.model.ArtistModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetSearchByArtistUseCase {
    suspend fun execute(artist: String): Flow<Result<List<ArtistModel>>>
}

class GetSearchByArtistUseCaseImpl
    @Inject
    constructor(
        private val searchRepository: SearchRepository,
        private val artistMapper: ArtistMapper,
    ) : GetSearchByArtistUseCase {
        override suspend fun execute(artist: String): Flow<Result<List<ArtistModel>>> {
            return searchRepository.getSearchByArtist(artist).map { response ->
                response.map { artistDto ->
                    artistMapper.toDomainModel(artistDto)
                }
            }
        }
    }
