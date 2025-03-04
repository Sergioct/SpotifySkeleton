package com.sergiocrespotoubes.spotify.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sergiocrespotoubes.navigation.Routes
import com.sergiocrespotoubes.spotify.navigation.navgraph.artistDetailScreen
import com.sergiocrespotoubes.spotify.navigation.navgraph.artistSearchScreen
import com.sergiocrespotoubes.spotify.navigation.navgraph.splashScreen
import com.sergiocrespotoubes.spotify.navigation.navgraph.trackDetailScreen

@Composable
fun SpotifyNavHost(mainNavController: NavHostController) {
    NavHost(
        navController = mainNavController,
        startDestination = Routes.Splash,
    ) {
        splashScreen(
            navigateToArtistSearch = {
                mainNavController.navigate(Routes.ArtistSearch) {
                    popUpTo(Routes.Splash) { inclusive = true }
                }
            },
        )
        artistSearchScreen(
            navigateToArtistDetail = { artistId ->
                mainNavController.navigate(Routes.ArtistDetail(artistId = artistId))
            },
            navigateToTrackDetail = { trackId ->
                mainNavController.navigate(Routes.TrackDetail(trackId = trackId))
            },
        )
        artistDetailScreen()
        trackDetailScreen()
    }
}
