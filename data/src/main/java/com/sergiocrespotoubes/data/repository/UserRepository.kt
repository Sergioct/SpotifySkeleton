package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.network.dto.AuthInfoDto
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getAuthInfo(): Flow<Result<AuthInfoDto>>
}
