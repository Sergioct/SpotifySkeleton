package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.AuthInfoDto
import com.sergiocrespotoubes.data.services.UserServices
import com.sergiocrespotoubes.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    val userServices: UserServices
) : UserRepository {
    override suspend fun getAuthInfo(): Flow<Result<AuthInfoModel>> = flow {
        emit(
            Result.success(
                AuthInfoModel(
                    accessToken = "1234567890",
                ),
            ),
        )
    }
}
