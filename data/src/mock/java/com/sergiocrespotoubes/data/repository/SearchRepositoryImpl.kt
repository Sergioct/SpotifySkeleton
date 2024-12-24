package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.network.dto.ArtistsListDto
import com.sergiocrespotoubes.data.network.dto.SearchDto
import com.sergiocrespotoubes.data.services.SearchServices
import com.sergiocrespotoubes.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val searchServices: SearchServices
) : SearchRepository {
    override suspend fun getSearchByArtist(artistName: String): Flow<Result<SearchDto>> =
        flow {
            emit(
                Result.success(
                    SearchDto(
                        artists = ArtistsListDto(
                            items = listOf(
                                ArtistDto(
                                    id = "1",
                                    name = "Artist 1",
                                    images = emptyList(),
                                    popularity = 0,
                                ),
                                ArtistDto(
                                    id = "2",
                                    name = "Artist 2",
                                    images = emptyList(),
                                    popularity = 1,
                                ),
                            ),
                        ),
                    )
                ),
            )
        }
}
