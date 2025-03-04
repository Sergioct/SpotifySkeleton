package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.network.datasource.ArtistNetworkDataSource
import com.sergiocrespotoubes.data.network.datasource.ArtistNetworkDataSourceImpl
import com.sergiocrespotoubes.data.network.datasource.SearchNetworkDataSource
import com.sergiocrespotoubes.data.network.datasource.SearchNetworkDataSourceImpl
import com.sergiocrespotoubes.data.network.datasource.TracksNetworkDataSource
import com.sergiocrespotoubes.data.network.datasource.TracksNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkDataSourceModule {
    @Binds
    fun bindsArtistNetworkDataSource(artistNetworkDataSourceImpl: ArtistNetworkDataSourceImpl): ArtistNetworkDataSource

    @Binds
    fun bindsSearchNetworkDataSource(searchNetworkDataSourceImpl: SearchNetworkDataSourceImpl): SearchNetworkDataSource

    @Binds
    fun bindsTracksNetworkDataSource(tracksNetworkDatasourceImpl: TracksNetworkDataSourceImpl): TracksNetworkDataSource
}
