package com.sergiocrespotoubes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.db.entities.ArtistEntity
import com.sergiocrespotoubes.data.db.entities.TrackEntity

@Database(
    version = 1,
    entities = [TrackEntity::class, ArtistEntity::class],
    exportSchema = false,
)
abstract class SpotifyDatabase : RoomDatabase() {
    abstract fun trackDao(): TrackDao

    abstract fun artistDao(): ArtistDao
}
