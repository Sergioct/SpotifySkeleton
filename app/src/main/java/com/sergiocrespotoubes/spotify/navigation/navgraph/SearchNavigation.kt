package com.sergiocrespotoubes.spotify.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sergiocrespotoubes.search.SearchScreen
import com.sergiocrespotoubes.navigation.Routes

fun NavGraphBuilder.artistSearchScreen() {
    composable(
        route = Routes.ArtistSearch.route,
    ) {
        SearchScreen()
    }
}
