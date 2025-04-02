package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.services.ArtistServices
import com.sergiocrespotoubes.data.services.SearchServices
import com.sergiocrespotoubes.data.services.TracksServices
import com.sergiocrespotoubes.data.services.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {
    @Singleton
    @Provides
    fun provideSearchServices(
        @Named("LOGGED") retrofit: Retrofit,
    ): SearchServices {
        return retrofit.create(SearchServices::class.java)
    }

    @Singleton
    @Provides
    fun provideArtistServices(
        @Named("LOGGED") retrofit: Retrofit,
    ): ArtistServices {
        return retrofit.create(ArtistServices::class.java)
    }

    @Singleton
    @Provides
    fun provideTracksServices(
        @Named("LOGGED") retrofit: Retrofit,
    ): TracksServices {
        return retrofit.create(TracksServices::class.java)
    }

    @Singleton
    @Provides
    fun provideUserServices(
        @Named("AUTH") retrofit: Retrofit,
    ): UserServices {
        return retrofit.create(UserServices::class.java)
    }
}
