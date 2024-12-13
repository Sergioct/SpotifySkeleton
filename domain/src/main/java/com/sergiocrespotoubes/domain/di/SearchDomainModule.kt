package com.sergiocrespotoubes.domain.di

import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCase
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SearchDomainModule {
    @Binds
    fun bindGetSearchByArtistUseCase(getSearchByArtistUseCaseImpl: GetSearchByArtistUseCaseImpl): GetSearchByArtistUseCase
}
