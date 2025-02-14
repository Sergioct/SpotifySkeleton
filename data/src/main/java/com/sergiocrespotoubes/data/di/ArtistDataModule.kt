package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.repository.ArtistRepositoryImpl
import com.sergiocrespotoubes.domain.repository.ArtistRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ArtistDataModule {
    @Binds
    fun bindsArtistRepository(artistRepository: ArtistRepositoryImpl): ArtistRepository
}
