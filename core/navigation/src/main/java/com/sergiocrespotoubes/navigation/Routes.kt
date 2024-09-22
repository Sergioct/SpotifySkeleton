package com.sergiocrespotoubes.navigation

import com.sergiocrespotoubes.domain.model.Song

sealed class Routes(val route: String) {
    data object Splash: Routes("splash")
    data object SongsList: Routes("song_list")
    data object SongDetail: Routes("song_detail/{song}"){
        fun createRoute(song: Song): String = "song_detail/$song"
    }
}