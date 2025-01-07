package com.sergiocrespotoubes.domain.di

import com.sergiocrespotoubes.domain.usecase.tracks.GetTrackByIdUseCase
import com.sergiocrespotoubes.domain.usecase.tracks.GetTrackByIdUseCaseImpl
import com.sergiocrespotoubes.domain.usecase.tracks.GetTracksByArtistIdUseCase
import com.sergiocrespotoubes.domain.usecase.tracks.GetTracksByArtistIdUseCaseImpl
import com.sergiocrespotoubes.domain.usecase.tracks.GetTracksFromDbUseCase
import com.sergiocrespotoubes.domain.usecase.tracks.GetTracksFromDbUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface TracksDomainModule {
    @Binds
    fun bindGetTrackByIdUseCase(getTrackByIdUseCaseImpl: GetTrackByIdUseCaseImpl): GetTrackByIdUseCase

    @Binds
    fun bindGetTracksByArtistIdUseCase(getTracksByArtistIdUseCaseImpl: GetTracksByArtistIdUseCaseImpl): GetTracksByArtistIdUseCase

    @Binds
    fun bindGetTracksFromDbUseCase(getTracksFromDbUseCaseImpl: GetTracksFromDbUseCaseImpl): GetTracksFromDbUseCase
}
