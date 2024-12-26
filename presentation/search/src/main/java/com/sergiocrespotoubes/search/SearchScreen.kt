package com.sergiocrespotoubes.search

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifyHorizontalProgressBar
import com.sergiocrespotoubes.ui.components.SpotifyTextField
import com.sergiocrespotoubes.ui.components.SpotifyToolbar
import com.sergiocrespotoubes.ui.theme.SpotifyDimen
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    Design(searchViewModel)
    ReadEvents(searchViewModel)
}

@Composable
private fun Design(searchViewModel: SearchViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier =
            Modifier
                .align(Alignment.TopCenter),
        ) {
            SpotifyToolbar(stringResource(R.string.app_name))

            val state = searchViewModel.state.collectAsState().value
            SpotifyTextField(
                modifier = Modifier
                    .padding(horizontal = SpotifyDimen.spaceBig()),
                label = stringResource(R.string.search_filter_label),
                leadingIcon = Icons.Default.Search,
                text = state.inputText,
                onValueChange = {
                    searchViewModel.onInputTextUpdate(it)
                },
            )
            SpotifyHorizontalProgressBar(state.loading)
            ArtistsList(state.artists)
        }
    }
}



@Composable
fun ReadEvents(searchViewModel: SearchViewModel) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        searchViewModel.event.collect { event ->
            when(event) {
                is SearchViewModel.Event.NavigateToArtistSearch -> {}
                is SearchViewModel.Event.ShowError -> {
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

@Composable
fun ArtistsList(artists: List<ArtistModel>) {
    artists.forEach { artist ->
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = artist.name
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SpotifyTheme {
        SearchScreen()
    }
}
