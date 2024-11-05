package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.services.SearchServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val searchServices: SearchServices
) : SearchRepository {
    override suspend fun getSearchArtistSongs(artistName: String): Flow<Result<ArtistDto>> =
        flow {
            emit(
                Result.success(
                    ArtistDto(
                        id = "1",
                        name = "artistName",
                        image = "image",
                        genres = listOf("genre"),
                        popularity = 1,
                        followers = 1,
                    ),
                ),
            )
        }
}
