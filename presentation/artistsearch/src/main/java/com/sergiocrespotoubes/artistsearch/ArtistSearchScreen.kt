package com.sergiocrespotoubes.artistsearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sergiocrespotoubes.ui.components.SpotifyTextTitleBold
import com.sergiocrespotoubes.ui.theme.SpotifyDimen
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun ArtistSearchScreen(
    artistSearchViewModel: ArtistSearchViewModel = hiltViewModel(),
) {
    Design()
    ReadEvents(
        artistSearchViewModel = artistSearchViewModel,
    )
}

@Composable
private fun Design() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = SpotifyDimen.spaceBig())
        ) {
            SpotifyTextTitleBold(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = SpotifyDimen.spaceMedium()),
                text = "ARTISTS WEB"
            )
        }
    }
}

@Composable
fun ReadEvents(
    artistSearchViewModel: ArtistSearchViewModel,
) {
    LaunchedEffect(Unit) {

    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SpotifyTheme {
        ArtistSearchScreen()
    }
}