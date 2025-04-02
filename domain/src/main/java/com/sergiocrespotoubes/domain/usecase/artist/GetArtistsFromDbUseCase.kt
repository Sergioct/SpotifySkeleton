package com.sergiocrespotoubes.domain.usecase.artist

import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.ArtistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetArtistsFromDbUseCase {
    suspend fun execute(): Flow<Result<List<ArtistModel>>>
}

class GetArtistsFromDbUseCaseImpl
    @Inject
    constructor(
        private val artistRepository: ArtistRepository,
    ) : GetArtistsFromDbUseCase {
        override suspend fun execute(): Flow<Result<List<ArtistModel>>> {
            return artistRepository.getArtistsFromDb()
        }
    }
