package com.sergiocrespotoubes.data.network.datasource

import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.db.entities.TrackEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface TracksNetworkDataSource {
    suspend fun getTracks(): Flow<List<TrackEntity>>
}

@Singleton
class TracksNetworkDataSourceImpl @Inject constructor(
    private val tracksDao: TrackDao,
) : TracksNetworkDataSource {
    override suspend fun getTracks(): Flow<List<TrackEntity>> {
        return tracksDao.getTracks()
    }
}