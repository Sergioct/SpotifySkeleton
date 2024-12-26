package com.sergiocrespotoubes.domain.di

import com.sergiocrespotoubes.domain.usecase.artist.GetArtistsFromDbUseCase
import com.sergiocrespotoubes.domain.usecase.artist.GetArtistsFromDbUseCaseImpl
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCase
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ArtistDomainModule {
    @Binds
    fun bindGetArtistsFromDbUseCase(getArtistsFromDbUseCase: GetArtistsFromDbUseCaseImpl): GetArtistsFromDbUseCase
}
