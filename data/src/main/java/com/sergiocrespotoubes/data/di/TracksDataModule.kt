package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.repository.TracksRepository
import com.sergiocrespotoubes.data.repository.TracksRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface TracksDataModule {
    @Binds
    fun bindsTracksRepository(
        tracksRepositoryImpl: TracksRepositoryImpl,
    ): TracksRepository
}
