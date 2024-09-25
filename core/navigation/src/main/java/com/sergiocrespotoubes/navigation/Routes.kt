package com.sergiocrespotoubes.navigation

sealed class Routes(val route: String) {
    data object Splash: Routes("splash")
    data object ArtistSearch: Routes("artist_search")
    data object TrackDetail: Routes("track_detail/{trackDetail}"){
        fun createRoute(trackDetail: TrackDetail): String = "track_detail/$trackDetail"
    }
}