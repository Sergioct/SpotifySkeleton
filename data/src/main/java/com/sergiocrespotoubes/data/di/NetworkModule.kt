package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.network.interceptors.AuthTokenInterceptor
import com.sergiocrespotoubes.spotify.managers.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        explicitNulls = false
    }

    @Singleton
    @Provides
    fun provideGenAccessTokenInterceptor(
        preferencesManager: PreferencesManager,
    ): AuthTokenInterceptor {
        return AuthTokenInterceptor(preferencesManager)
    }

}