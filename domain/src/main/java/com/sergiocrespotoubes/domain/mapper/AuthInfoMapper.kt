package com.sergiocrespotoubes.domain.mapper

import com.sergiocrespotoubes.data.dto.AuthInfoDto
import com.sergiocrespotoubes.domain.model.AuthInfoModel
import javax.inject.Inject

class AuthInfoMapper @Inject constructor(): Mapper<AuthInfoDto, AuthInfoModel> {
    override fun toDomainModel(value: AuthInfoDto): AuthInfoModel {
        return AuthInfoModel(
            accessToken = value.accessToken,
        )
    }

    override fun toDto(value: AuthInfoModel): AuthInfoDto {
        TODO("Not yet implemented")
    }
}