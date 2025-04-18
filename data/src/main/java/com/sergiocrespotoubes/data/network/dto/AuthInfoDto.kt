package com.sergiocrespotoubes.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthInfoDto(
    @SerialName("access_token") val accessToken: String,
)
