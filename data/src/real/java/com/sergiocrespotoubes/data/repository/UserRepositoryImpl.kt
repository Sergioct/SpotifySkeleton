package com.sergiocrespotoubes.data.repository

import com.sergiocrespotoubes.data.dto.AuthInfoDto
import com.sergiocrespotoubes.data.services.UserServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl
    @Inject
    constructor(
        private val userServices: UserServices,
    ) : UserRepository {
        override suspend fun getAuthInfo(): Flow<Result<AuthInfoDto>> =
            flow {
                emit(userServices.getAuthInfo())
            }
    }
