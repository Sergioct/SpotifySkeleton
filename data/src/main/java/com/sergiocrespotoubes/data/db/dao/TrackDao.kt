package com.sergiocrespotoubes.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sergiocrespotoubes.data.db.entities.TrackEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks")
    fun getTracks(): Flow<List<TrackEntity>>

    @Insert
    fun insertTrack(track: TrackEntity)

    @Update
    fun updateTrack(track: TrackEntity)

    @Delete
    fun deleteTrack(track: TrackEntity)
}