package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.AuthInfoDto
import com.sergiocrespotoubes.data.services.UserServices

class UserRepositoryImpl(val userServices: UserServices) : UserRepository {
    override suspend fun getAuthInfo(): Result<AuthInfoDto> {
        return userServices.getAuthInfo()
    }
}