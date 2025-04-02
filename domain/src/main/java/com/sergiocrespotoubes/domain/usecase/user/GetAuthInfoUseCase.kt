package com.sergiocrespotoubes.domain.usecase.user

import com.sergiocrespotoubes.domain.model.AuthInfoModel
import com.sergiocrespotoubes.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetAuthInfoUseCase {
    suspend fun execute(): Flow<Result<AuthInfoModel>>
}

class GetAuthInfoUseCaseImpl
    @Inject
    constructor(
        private val userRepository: UserRepository,
    ) : GetAuthInfoUseCase {
        override suspend fun execute(): Flow<Result<AuthInfoModel>> {
            return userRepository.getAuthInfo()
        }
    }
