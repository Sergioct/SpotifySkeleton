package com.sergiocrespotoubes.spotify.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sergiocrespotoubes.navigation.Routes
import com.sergiocrespotoubes.search.SearchScreen

fun NavGraphBuilder.artistSearchScreen(
    navigateToArtistDetail: (String) -> Unit,
    navigateToTrackDetail: (String) -> Unit,
) {
    composable<Routes.ArtistSearch> {
        SearchScreen(
            navigateToArtistDetail = navigateToArtistDetail,
            navigateToTrackDetail = navigateToTrackDetail,
        )
    }
}
