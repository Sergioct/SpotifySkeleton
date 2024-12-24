package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.domain.repository.UserRepository
import com.sergiocrespotoubes.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UserDataModule {
    @Binds
    fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}
