package com.sergiocrespotoubes.data.network.datasource

import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.db.entities.TrackEntity
import kotlinx.coroutines.flow.Flow

interface TracksDbDataSource {
    suspend fun getTracks(): Flow<List<TrackEntity>>
}

class TracksDbDataSourceImpl(
    private val tracksDao: TrackDao,
) : TracksDbDataSource {
    override suspend fun getTracks(): Flow<List<TrackEntity>> {
        return tracksDao.getTracks()
    }

}