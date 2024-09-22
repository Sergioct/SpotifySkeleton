package com.sergiocrespotoubes.preferences.di

import com.sergiocrespotoubes.preferences.PreferencesManagerImpl
import com.sergiocrespotoubes.spotify.managers.PreferencesManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PreferencesModule {
    @Binds
    fun bindsPreferencesManager(impl: PreferencesManagerImpl): PreferencesManager
}