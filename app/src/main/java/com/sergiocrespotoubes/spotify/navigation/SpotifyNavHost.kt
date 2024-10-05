package com.sergiocrespotoubes.spotify.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sergiocrespotoubes.navigation.Routes
import com.sergiocrespotoubes.spotify.navigation.navgraph.artistSearchScreen
import com.sergiocrespotoubes.spotify.navigation.navgraph.splashScreen

@Composable
fun SpotifyNavHost(
    mainNavController: NavHostController
) {
    NavHost(
        navController = mainNavController,
        startDestination = Routes.Splash.route
    ){
        splashScreen(
            navigateToArtistSearch = { mainNavController.navigate(Routes.ArtistSearch.route) }
        )
        artistSearchScreen()
    }
}