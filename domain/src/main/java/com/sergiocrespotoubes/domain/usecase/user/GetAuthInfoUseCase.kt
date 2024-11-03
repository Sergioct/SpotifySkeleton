package com.sergiocrespotoubes.domain.usecase.user

import com.sergiocrespotoubes.data.repository.UserRepository
import com.sergiocrespotoubes.domain.mapper.AuthInfoMapper
import com.sergiocrespotoubes.domain.model.AuthInfoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetAuthInfoUseCase {
    suspend fun execute(): Flow<Result<AuthInfoModel>>
}

class GetAuthInfoUseCaseImpl
    @Inject
    constructor(
        private val userRepository: UserRepository,
        private val authInfoMapper: AuthInfoMapper,
    ) : GetAuthInfoUseCase {
        override suspend fun execute(): Flow<Result<AuthInfoModel>> {
            return userRepository.getAuthInfo().map { response ->
                response.map { authDto -> authInfoMapper.toDomainModel(authDto) }
            }
        }
    }
