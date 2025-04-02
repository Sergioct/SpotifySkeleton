package com.sergiocrespotoubes.domain.repository

import com.sergiocrespotoubes.domain.model.AuthInfoModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getAuthInfo(): Flow<Result<AuthInfoModel>>
}
