package com.sergiocrespotoubes.data.dto

import kotlinx.serialization.SerialName

data class AuthInfoDto(
    @SerialName("access_token") val accessToken: String,
)