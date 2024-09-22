package com.sergiocrespotoubes.preferences

import android.content.Context
import com.sergiocrespotoubes.spotify.managers.PreferenceKeys
import com.sergiocrespotoubes.spotify.managers.PreferencesManager
import javax.inject.Inject

const val SHARED_PREFERENCE_FILE = "com.sergiocrespotoubes.spotify.preferences"

class PreferencesManagerImpl @Inject constructor(context: Context): PreferencesManager {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)

    override fun getAuthToken(): String {
        return sharedPreferences.getString(PreferenceKeys.AUTH_TOKEN.key, "") ?: ""
    }

    override fun setAuthToken(authToken: String) {
        sharedPreferences.edit().putString(PreferenceKeys.AUTH_TOKEN.key, authToken).apply()
    }
}