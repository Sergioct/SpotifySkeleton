package com.sergiocrespotoubes.data.network.interceptors

import com.sergiocrespotoubes.common.SpotifyLog
import com.sergiocrespotoubes.preferences.PreferencesManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthTokenInterceptor
    @Inject
    constructor(
        private val preferencesManager: PreferencesManager,
    ) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val token = preferencesManager.getAuthToken()
            val builder = request.newBuilder()
            if (
                token.isNotEmpty() &&
                !request.url.toUrl().toString().contains("/api/token")
                )
                {
                    builder.addHeader("Authorization", "Bearer $token")
                }
            val requestWithAuthHeader = builder.build()
            return chain.proceed(requestWithAuthHeader)
        }
    }
