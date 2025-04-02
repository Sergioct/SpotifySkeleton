package com.sergiocrespotoubes.data.di

import com.sergiocrespotoubes.data.repository.UserRepositoryImpl
import com.sergiocrespotoubes.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UserDataModule {
    @Binds
    fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}
