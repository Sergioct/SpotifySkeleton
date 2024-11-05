package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.AuthInfoDto
import com.sergiocrespotoubes.data.services.UserServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    val userServices: UserServices
) : UserRepository {
    override suspend fun getAuthInfo(): Flow<Result<AuthInfoDto>> = flow {
        emit(
            Result.success(
                AuthInfoDto(
                    accessToken = "1234567890",
                ),
            ),
        )
    }
}
