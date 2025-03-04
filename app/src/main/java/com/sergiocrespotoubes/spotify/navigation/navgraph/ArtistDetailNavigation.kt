package com.sergiocrespotoubes.spotify.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sergiocrespotoubes.artistdetail.ArtistDetailScreen
import com.sergiocrespotoubes.navigation.Routes

fun NavGraphBuilder.artistDetailScreen() {
    composable<Routes.ArtistDetail> {
        val args = it.toRoute<Routes.ArtistDetail>()
        ArtistDetailScreen(args.artistId)
    }
}
