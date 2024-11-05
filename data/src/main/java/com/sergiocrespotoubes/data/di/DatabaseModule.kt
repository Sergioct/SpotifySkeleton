package com.sergiocrespotoubes.data.di

import android.content.Context
import androidx.room.Room
import com.sergiocrespotoubes.data.db.SpotifyDatabase
import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.dao.TrackDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideArtistDao(spotifyDatabase: SpotifyDatabase): ArtistDao {
        return spotifyDatabase.artistDao()
    }

    @Provides
    fun provideTrackDao(spotifyDatabase: SpotifyDatabase): TrackDao {
        return spotifyDatabase.trackDao()
    }

    @Provides
    @Singleton
    fun provideSpotifyDatabase(@ApplicationContext appContext: Context): SpotifyDatabase {
        return Room.databaseBuilder(
            appContext,
            SpotifyDatabase::class.java,
            "spotify_skeleton.db"
        ).build()
    }
}