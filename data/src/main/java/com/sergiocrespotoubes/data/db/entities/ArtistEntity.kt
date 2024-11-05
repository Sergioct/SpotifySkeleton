package com.sergiocrespotoubes.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val image: String,
    val genres: List<String>,
    val popularity: Int,
    val followers: Int,
)
