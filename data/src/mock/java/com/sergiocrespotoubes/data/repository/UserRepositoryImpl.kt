package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.AuthInfoDto
import com.sergiocrespotoubes.data.services.UserServices
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val userServices: UserServices) : UserRepository {
    override suspend fun getAuthInfo(): Result<AuthInfoDto> {
        return Result.success(
            AuthInfoDto(
                accessToken = "1234567890"
            )
        )
    }
}