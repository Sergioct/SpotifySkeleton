package com.sergiocrespotoubes.domain.di

import com.sergiocrespotoubes.domain.usecase.user.GetAuthInfoUseCase
import com.sergiocrespotoubes.domain.usecase.user.GetAuthInfoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UserDomainModule {
    @Binds
    fun bindGetAuthInfoUseCase(getAuthInfoUseCase: GetAuthInfoUseCaseImpl): GetAuthInfoUseCase
}
