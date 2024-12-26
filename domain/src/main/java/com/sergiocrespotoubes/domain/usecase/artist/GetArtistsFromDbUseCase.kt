package com.sergiocrespotoubes.domain.usecase.artist

import com.sergiocrespotoubes.common.SpotifyLog
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.ArtistRepository
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetArtistsFromDbUseCase {
    suspend fun execute(): Flow<Result<List<ArtistModel>>>
}

class GetArtistsFromDbUseCaseImpl @Inject constructor(
    private val artistRepository: ArtistRepository,
) : GetArtistsFromDbUseCase {
    override suspend fun execute(): Flow<Result<List<ArtistModel>>> {
        SpotifyLog.i("GetArtistsFromDbUseCase.execute()")
        return artistRepository.getArtistsFromDb()
    }
}
