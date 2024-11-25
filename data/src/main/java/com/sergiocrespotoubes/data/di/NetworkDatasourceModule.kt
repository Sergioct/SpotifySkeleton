package com.sergiocrespotoubes.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetoworkDatasourceModule {
    @Binds
    fun bindsArtistsNetoworkDatasourceImpl(netoworkDatasourceImpl: TracksNetoworkDatasourceImpl): TracksNetoworkDatasource

    @Binds
    fun bindsTracksNetoworkDatasourceImpl(netoworkDatasourceImpl: TracksNetoworkDatasourceImpl): TracksNetoworkDatasource
}