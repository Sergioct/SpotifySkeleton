package com.sergiocrespotoubes.preferences

interface PreferencesManager {
    fun getAuthToken(): String

    fun setAuthToken(authToken: String)
}
