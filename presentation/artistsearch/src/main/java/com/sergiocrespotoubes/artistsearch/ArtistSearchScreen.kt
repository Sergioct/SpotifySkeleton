package com.sergiocrespotoubes.artistsearch

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifyTextField
import com.sergiocrespotoubes.ui.theme.SpotifyDimen
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun ArtistSearchScreen(
    artistSearchViewModel: ArtistSearchViewModel = hiltViewModel()
) {
    Design(artistSearchViewModel)
    ReadEvents(artistSearchViewModel)
}

@Composable
private fun Design(artistSearchViewModel: ArtistSearchViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier =
                Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = SpotifyDimen.spaceBig()),
        ) {
            SpotifyTextField(
                label = "Search for an artist",
                leadingIcon = Icons.Default.Search,
                text = "",
                onValueChange = {
                    artistSearchViewModel.onInputTextUpdate(it)
                },
            )
        }
    }
}

@Composable
fun ReadEvents(artistSearchViewModel: ArtistSearchViewModel) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        artistSearchViewModel.event.collect { event ->
            when(event) {
                is ArtistSearchViewModel.Event.NavigateToArtistSearch -> {}
                is ArtistSearchViewModel.Event.ShowError -> {
                    showToastError(context)
                }
            }
        }

    }
}

private fun showToastError(context: Context) {
    Toast.makeText(
        context,
        context.getString(R.string.splash_error_message),
        Toast.LENGTH_LONG,
    ).show()
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SpotifyTheme {
        ArtistSearchScreen()
    }
}
