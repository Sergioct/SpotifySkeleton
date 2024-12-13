package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.domain.repository.SearchRepository
import com.sergiocrespotoubes.data.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SearchDataModule {
    @Binds
    fun bindsSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository
}
