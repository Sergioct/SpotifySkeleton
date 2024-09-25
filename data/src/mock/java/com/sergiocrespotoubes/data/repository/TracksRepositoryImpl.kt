package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.TrackDto
import com.sergiocrespotoubes.data.services.TracksServices

class TracksRepositoryImpl(val tracksServices: TracksServices) : TracksRepository {
    override suspend fun getTracksByArtistId(artistId: String): Result<List<TrackDto>> {
        return Result.success(
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
                )
            )
        )
    }

    override suspend fun getTrackById(trackId: String): Result<TrackDto> {
        return Result.success(
            TrackDto(
                id = "1",
                name = "trackName",
                previewUrl = "previewUrl",
                duration = 1,
                albumId = "albumId",
                imageUrl = "imageUrl",
                isFavorite = true,
                artistId = "1",
            )
        )
    }
}