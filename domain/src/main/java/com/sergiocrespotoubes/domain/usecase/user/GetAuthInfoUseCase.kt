package com.sergiocrespotoubes.domain.usecase.user

import com.sergiocrespotoubes.data.repository.UserRepository
import com.sergiocrespotoubes.domain.mapper.AuthInfoMapper
import com.sergiocrespotoubes.domain.model.AuthInfoModel
import javax.inject.Inject

interface GetAuthInfoUseCase {
    suspend fun execute(): Result<AuthInfoModel>
}

class GetAuthInfoUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val authInfoMapper: AuthInfoMapper,
): GetAuthInfoUseCase {
    override suspend fun execute(): Result<AuthInfoModel> {
        return userRepository.getAuthInfo().map { authDto ->
            authInfoMapper.toDomainModel(authDto)
        }
    }
}