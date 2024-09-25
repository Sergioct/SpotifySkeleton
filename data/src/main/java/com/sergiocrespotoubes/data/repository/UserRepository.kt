package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.AuthInfoDto

interface UserRepository {
    suspend fun getAuthInfo(): Result<AuthInfoDto>
}