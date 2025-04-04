package com.sergiocrespotoubes.data.services

import com.sergiocrespotoubes.data.network.dto.AuthInfoDto
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface UserServices {
    @POST(value = "/api/token")
    suspend fun getAuthInfo(
        @Query("grant_type") granType: String = "client_credentials",
        @Query("client_id") clientId: String = "e57a98d00b934c499c102ddfaeafb045",
        @Query("client_secret") clientSecret: String = "c561334da94040b28a5831d2d211855a",
        @Header("Content-Type") contentType: String = "application/x-www-form-urlencoded",
    ): Result<AuthInfoDto>
}
