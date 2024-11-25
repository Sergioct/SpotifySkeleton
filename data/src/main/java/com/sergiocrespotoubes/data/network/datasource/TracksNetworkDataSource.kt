package com.sergiocrespotoubes.data.network.datasource

import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.db.entities.TrackEntity
import kotlinx.coroutines.flow.Flow

interface TracksNetworkDataSource {
    suspend fun getTracks(): Flow<List<TrackEntity>>
}

class TracksNetworkDataSourceImpl(
    private val tracksDao: TrackDao,
) : TracksNetworkDataSource {
    override suspend fun getTracks(): Flow<List<TrackEntity>> {
        return tracksDao.getTracks()
    }
}