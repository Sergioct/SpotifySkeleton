package com.sergiocrespotoubes.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtistDao {
    @Query("SELECT * FROM artists")
    fun getArtists(): Flow<List<ArtistEntity>>

    @Insert
    fun insertArtist(artist: ArtistEntity)

    @Update
    fun updateArtist(artist: ArtistEntity)

    @Delete
    fun deleteArtist(artist: ArtistEntity)
}