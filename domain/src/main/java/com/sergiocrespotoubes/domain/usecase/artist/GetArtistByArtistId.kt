package com.sergiocrespotoubes.domain.usecase.artist

import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.ArtistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetArtistByArtistId {
    suspend fun execute(artistId: String): Flow<Result<ArtistModel>>
}

class GetArtistByArtistIdImpl
    @Inject
    constructor(
        private val artistRepository: ArtistRepository,
    ) : GetArtistByArtistId {
        override suspend fun execute(artistId: String): Flow<Result<ArtistModel>> {
            return artistRepository.getArtistByArtistId(artistId)
        }
    }
