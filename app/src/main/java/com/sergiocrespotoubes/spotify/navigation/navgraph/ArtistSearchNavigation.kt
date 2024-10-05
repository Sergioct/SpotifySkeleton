package com.sergiocrespotoubes.spotify.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sergiocrespotoubes.artistsearch.ArtistSearchScreen
import com.sergiocrespotoubes.navigation.Routes

fun NavGraphBuilder.artistSearchScreen() {
    composable(
        route = Routes.ArtistSearch.route,
    ) {
        ArtistSearchScreen()
    }
}
