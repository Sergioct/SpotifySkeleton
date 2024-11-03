package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.ArtistDto
import com.sergiocrespotoubes.data.services.SearchServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl(private val searchServices: SearchServices) : SearchRepository {
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
