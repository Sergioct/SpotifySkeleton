package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.TrackDto
import com.sergiocrespotoubes.data.services.TracksServices
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.repository.ArtistRepository
import com.sergiocrespotoubes.domain.repository.TracksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistRepositoryImpl @Inject constructor(
    val tracksServices: TracksServices
) : ArtistRepository {
    override suspend fun getArtistsFromDb(): Flow<Result<List<ArtistModel>>> =
        flow {
            emit(
                Result.success(
                    listOf(
                        ArtistModel(
                            id = "1",
                            name = "Artist 1",
                            popularity = 0,
                            urlPicture = "",
                        )
                    )
                ),
            )
        }


}
