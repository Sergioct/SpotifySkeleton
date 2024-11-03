package com.sergiocrespotoubes.spotify.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sergiocrespotoubes.navigation.Routes
import com.sergiocrespotoubes.splash.SplashScreen

fun NavGraphBuilder.splashScreen(navigateToArtistSearch: () -> Unit) {
    composable(
        route = Routes.Splash.route,
    ) {
        SplashScreen(
            navigateToArtistSearch = navigateToArtistSearch,
        )
    }
}
