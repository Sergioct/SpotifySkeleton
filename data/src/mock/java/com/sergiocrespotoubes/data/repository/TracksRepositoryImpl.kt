package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.TrackDto
import com.sergiocrespotoubes.data.services.TracksServices
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TracksRepositoryImpl @Inject constructor(
    val tracksServices: TracksServices
) : TracksRepository {
    override suspend fun getTracksByArtistId(artistId: String): Flow<Result<List<TrackModel>>> =
        flow {
            emit(
                Result.success(
                    listOf(
                        TrackDto(
                            id = "1",
                            name = "trackName",
                            previewUrl = "previewUrl",
                            duration = 1,
                            albumId = "albumId",
                            imageUrl = "imageUrl",
                            isFavorite = true,
                            artistId = "1",
                        ),
                    ),
                ),
            )
        }

    override suspend fun getTrackById(trackId: String): Flow<Result<TrackDto>> =
        flow {
            emit(
                Result.success(
                    TrackDto(
                        id = "1",
                        name = "trackName",
                        previewUrl = "previewUrl",
                        duration = 1,
                        albumId = "albumId",
                        imageUrl = "imageUrl",
                        isFavorite = true,
                        artistId = "1",
                    ),
                ),
            )
        }
}
