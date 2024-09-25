package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.services.TracksServices

class UserRepositoryImpl(val tracksServices: TracksServices) : TracksRepository {
    override fun getTrackById(trackId: String): List<TrackDto> {
        tracksServices.getTrackById(trackId)
    }

}