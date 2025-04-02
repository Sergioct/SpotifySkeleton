package com.sergiocrespotoubes.domain.di

import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCase
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCaseImpl
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByTrackUseCase
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByTrackUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SearchDomainModule {
    @Binds
    fun bindGetSearchByArtistUseCase(getSearchByArtistUseCaseImpl: GetSearchByArtistUseCaseImpl): GetSearchByArtistUseCase

    @Binds
    fun bindGetSearchByTrackUseCase(getSearchByTrackUseCaseImpl: GetSearchByTrackUseCaseImpl): GetSearchByTrackUseCase
}
