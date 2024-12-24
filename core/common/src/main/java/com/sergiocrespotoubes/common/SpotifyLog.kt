package com.sergiocrespotoubes.common

import android.util.Log

object SpotifyLog {
    fun i(text: String){
        if(BuildConfig.DEBUG){
            Log.i("SpotifyLog", text)
        }
    }
}