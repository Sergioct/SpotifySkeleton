package com.sergiocrespotoubes.domain.usecase.search

import com.sergiocrespotoubes.common.SpotifyLog
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetSearchByArtistUseCase {
    suspend fun execute(artist: String): Flow<Result<List<ArtistModel>>>
}

class GetSearchByArtistUseCaseImpl @Inject constructor(
    private val searchRepository: SearchRepository,
) : GetSearchByArtistUseCase {
    override suspend fun execute(artist: String): Flow<Result<List<ArtistModel>>> {
        SpotifyLog.i("GetSearchByArtistUseCaseImpl.execute($artist)")
        return searchRepository.getSearchByArtist(artist)
    }
}
