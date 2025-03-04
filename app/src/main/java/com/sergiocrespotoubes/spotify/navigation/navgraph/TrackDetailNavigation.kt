package com.sergiocrespotoubes.spotify.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sergiocrespotoubes.navigation.Routes
import com.sergiocrespotoubes.trackdetail.TrackDetailScreen

fun NavGraphBuilder.trackDetailScreen() {
    composable<Routes.TrackDetail> {
        val args = it.toRoute<Routes.TrackDetail>()
        TrackDetailScreen(args.trackId)
    }
}
