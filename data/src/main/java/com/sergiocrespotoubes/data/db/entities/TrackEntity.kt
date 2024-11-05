package com.sergiocrespotoubes.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracks")
data class TrackEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val duration: Int,
    val artistId: String,
    val albumId: String,
    val previewUrl: String,
    val imageUrl: String,
    val isFavorite: Boolean,
)
