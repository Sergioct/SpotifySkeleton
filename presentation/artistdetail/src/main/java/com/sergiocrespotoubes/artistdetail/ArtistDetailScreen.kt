package com.sergiocrespotoubes.artistdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun ArtistDetailScreen(
    artistDetailViewModel: ArtistDetailViewModel = hiltViewModel()
) {
    Design(artistDetailViewModel)
    ReadEvents(artistDetailViewModel)
}

@Composable
private fun Design(artistDetailViewModel: ArtistDetailViewModel) {
    Column(
        modifier =
        Modifier
            .fillMaxSize(),
    ) {
        //SpotifyToolbar(stringResource(R.string.app_name))
        Column {

        }
    }
}

@Composable
fun ReadEvents(artistDetailViewModel: ArtistDetailViewModel) {
    val context = LocalContext.current
    //LaunchedEffect(Unit) {
    //    searchViewModel.event.collect { event ->
    //        when(event) {
    //            is SearchViewModel.Event.NavigateToArtistSearch -> {}
    //            is SearchViewModel.Event.ShowError -> {
    //                showToastError(context)
    //            }
    //        }
    //    }
    //}
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SpotifyTheme {
        ArtistDetailScreen()
    }
}
