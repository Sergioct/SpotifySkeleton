package com.sergiocrespotoubes.spotify.managers

interface PreferencesManager {
    fun getAuthToken(): String
    fun setAuthToken(authToken: String)
}