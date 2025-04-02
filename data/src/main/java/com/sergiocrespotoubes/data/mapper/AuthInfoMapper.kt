package com.sergiocrespotoubes.data.mapper

import com.sergiocrespotoubes.data.network.dto.AuthInfoDto
import com.sergiocrespotoubes.domain.model.AuthInfoModel

fun AuthInfoDto.toModel(): AuthInfoModel {
    return AuthInfoModel(
        accessToken = this.accessToken,
    )
}
