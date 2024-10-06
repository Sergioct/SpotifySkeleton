package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.AuthInfoDto
import com.sergiocrespotoubes.data.services.UserServices
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userServices: UserServices
) : UserRepository {
    override suspend fun getAuthInfo(): Result<AuthInfoDto> {
        return userServices.getAuthInfo()
    }
}