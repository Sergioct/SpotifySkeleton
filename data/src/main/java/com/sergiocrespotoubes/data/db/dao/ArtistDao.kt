package com.sergiocrespotoubes.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtistDao {
    @Query("SELECT * FROM artists")
    fun getArtists(): Flow<List<ArtistEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtist(artist: ArtistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtists(artists: List<ArtistEntity>)

    @Update
    fun updateArtist(artist: ArtistEntity)

    @Delete
    fun deleteArtist(artist: ArtistEntity)

    @Query("DELETE FROM artists")
    fun clearAll()
}
