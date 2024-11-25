package com.sergiocrespotoubes.data.di

import android.content.Context
import androidx.room.Room
import com.sergiocrespotoubes.data.db.SpotifyDatabase
import com.sergiocrespotoubes.data.db.dao.ArtistDao
import com.sergiocrespotoubes.data.db.dao.TrackDao
import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasourceImpl
import com.sergiocrespotoubes.data.db.datasource.TracksDbDataSource
import com.sergiocrespotoubes.data.repository.TracksRepository
import com.sergiocrespotoubes.data.repository.TracksRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DbDatasourceModule {
    @Binds
    fun bindsArtistsDbDatasourceImpl(dbDatasourceImpl: ArtistsDbDatasourceImpl): ArtistsDbDatasource

    @Binds
    fun bindsTracksDbDatasourceImpl(dbDatasourceImpl: ArtistsDbDatasourceImpl): TracksDbDataSource
}