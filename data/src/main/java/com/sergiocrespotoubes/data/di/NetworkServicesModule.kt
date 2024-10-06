package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.services.SearchServices
import com.sergiocrespotoubes.data.services.TracksServices
import com.sergiocrespotoubes.data.services.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {
    @Singleton
    @Provides
    fun provideSearchServices(retrofit: Retrofit): SearchServices {
        return retrofit.create(SearchServices::class.java)
    }

    @Singleton
    @Provides
    fun provideTracksServices(retrofit: Retrofit): TracksServices {
        return retrofit.create(TracksServices::class.java)
    }

    @Singleton
    @Provides
    fun provideUserServices(retrofit: Retrofit): UserServices {
        return retrofit.create(UserServices::class.java)
    }
}