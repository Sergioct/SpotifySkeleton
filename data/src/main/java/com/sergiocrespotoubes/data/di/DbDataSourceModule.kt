package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasource
import com.sergiocrespotoubes.data.db.datasource.ArtistsDbDatasourceImpl
import com.sergiocrespotoubes.data.db.datasource.TracksDbDataSource
import com.sergiocrespotoubes.data.db.datasource.TracksDbDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DbDataSourceModule {
    @Binds
    fun bindsArtistsDbDatasource(dbDatasourceImpl: ArtistsDbDatasourceImpl): ArtistsDbDatasource

    @Binds
    fun bindsTracksDbDataSource(tracksDbDataSource: TracksDbDataSourceImpl): TracksDbDataSource
}
