package com.sergiocrespotoubes.search

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifySpinnerLoading
import com.sergiocrespotoubes.ui.components.SpotifyTextField
import com.sergiocrespotoubes.ui.components.SpotifyTextMedium
import com.sergiocrespotoubes.ui.components.SpotifyTextSmall
import com.sergiocrespotoubes.ui.components.SpotifyToolbar
import com.sergiocrespotoubes.ui.theme.SpotifyDimen
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel(),
    navigateToArtistDetail: (String) -> Unit,
    navigateToTrackDetail: (String) -> Unit,
) {
    Design(searchViewModel)
    ReadEvents(
        searchViewModel,
        navigateToArtistDetail = navigateToArtistDetail,
        navigateToTrackDetail = navigateToTrackDetail,
    )
}

@Composable
private fun Design(searchViewModel: SearchViewModel) {
    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        SpotifyToolbar(stringResource(R.string.app_name))

        val state = searchViewModel.state.collectAsState().value
        SpotifyTextField(
            modifier =
                Modifier
                    .padding(top = SpotifyDimen.spaceBig())
                    .padding(horizontal = SpotifyDimen.spaceBig()),
            label = stringResource(R.string.search_filter_label),
            leadingIcon = Icons.Default.Search,
            text = state.inputText,
            onValueChange = {
                searchViewModel.onInputTextUpdate(it)
            },
        )
        LazyColumn(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = SpotifyDimen.spaceMedium()),
        ) {
            item {
                SpotifySpinnerLoading(state.artistLoading)
            }
            item {
                ArtistsList(
                    searchViewModel = searchViewModel,
                    state.artists,
                )
            }
            item {
                SpotifySpinnerLoading(state.trackLoading)
            }
            item {
                TracksList(state.tracks)
            }
        }
    }
}

@Composable
fun ReadEvents(
    searchViewModel: SearchViewModel,
    navigateToArtistDetail: (String) -> Unit,
    navigateToTrackDetail: (String) -> Unit,
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        searchViewModel.event.collect { event ->
            when (event) {
                is SearchViewModel.Event.NavigateToArtistDetail -> {
                    navigateToArtistDetail(event.artistId)
                }
                is SearchViewModel.Event.NavigateToTrackDetail -> {
                    navigateToTrackDetail(event.trackId)
                }
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
fun ArtistsList(
    searchViewModel: SearchViewModel,
    artists: List<ArtistModel>,
) {
    if (artists.isNotEmpty()) {
        SpotifyTextMedium(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(all = SpotifyDimen.spaceMedium()),
            text = stringResource(R.string.search_subtitle_artists),
        )
        LazyRow {
            artists.forEach { artist ->
                item {
                    Column(
                        modifier =
                            Modifier
                                .padding(horizontal = SpotifyDimen.spaceMedium())
                                .clickable {
                                    searchViewModel.onArtistClick(artist.id)
                                },
                    ) {
                        AsyncImage(
                            modifier =
                                Modifier
                                    .width(96.dp)
                                    .height(96.dp),
                            model = artist.urlPicture,
                            placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            error = painterResource(R.drawable.placeholder),
                        )
                        SpotifyTextSmall(
                            modifier =
                                Modifier
                                    .width(96.dp)
                                    .padding(top = SpotifyDimen.spaceSmall()),
                            text = artist.name,
                            maxLines = 1,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TracksList(tracks: List<TrackModel>) {
    if (tracks.isNotEmpty()) {
        Text(
            modifier =
                Modifier
                    .fillMaxWidth(),
            text = stringResource(R.string.search_subtitle_tracks),
        )
        tracks.forEach { track ->
            Text(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                text = track.name,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SpotifyTheme {
        SearchScreen(
            navigateToArtistDetail = {},
            navigateToTrackDetail = {},
        )
    }
}
