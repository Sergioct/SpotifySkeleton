package com.sergiocrespotoubes.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sergiocrespotoubes.data.BuildConfig
import com.sergiocrespotoubes.data.network.interceptors.AuthTokenInterceptor
import com.sergiocrespotoubes.spotify.managers.PreferencesManager
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val READ_TIMEOUT = 30L
private const val CONNECT_TIMEOUT = 30L

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

    @Singleton
    @Provides
    fun provideOkhttp(
        authTokenInterceptor: AuthTokenInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(authTokenInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(networkJson: Json, okhttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .client(okhttpClient)
            .build()
    }

}