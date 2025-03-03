package com.sergiocrespotoubes.trackdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun TrackDetailScreen(
    trackDetailViewModel: TrackDetailViewModel = hiltViewModel()
) {
    Design(trackDetailViewModel)
    ReadEvents(trackDetailViewModel)
}

@Composable
private fun Design(trackDetailViewModel: TrackDetailViewModel) {
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
fun ReadEvents(trackDetailViewModel: TrackDetailViewModel) {
    val context = LocalContext.current
    //LaunchedEffect(Unit) {
    //    trackDetailViewModel.event.collect { event ->
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
        TrackDetailScreen()
    }
}
