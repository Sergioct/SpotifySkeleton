package com.sergiocrespotoubes.data.network.datasource

import com.sergiocrespotoubes.data.network.dto.ArtistDto
import com.sergiocrespotoubes.data.services.ArtistServices
import javax.inject.Inject
import javax.inject.Singleton

interface ArtistNetworkDataSource {
    suspend fun getArtistByArtistId(artistId: String): Result<ArtistDto>
}

@Singleton
class ArtistNetworkDataSourceImpl
    @Inject
    constructor(
        private val artistServices: ArtistServices,
    ) : ArtistNetworkDataSource {
        override suspend fun getArtistByArtistId(artistId: String): Result<ArtistDto> {
            val result = artistServices.getArtistByArtistId(artistId = artistId)
            return result
        }
    }
