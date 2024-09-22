package com.sergiocrespotoubes.spotify.di

import com.sergiocrespotoubes.spotify.managers.PreferencesManager
import com.sergiocrespotoubes.spotify.managers.PreferencesManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ManagersModule {
    @Binds
    fun bindsPreferencesManager(impl: PreferencesManagerImpl): PreferencesManager
}