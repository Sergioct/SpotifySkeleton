package com.sergiocrespotoubes.artistdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifyTextTitleBold
import com.sergiocrespotoubes.ui.components.SpotifyToolbar
import com.sergiocrespotoubes.ui.components.context.track.TrackItem
import com.sergiocrespotoubes.ui.components.error.ShowSpotifyError
import com.sergiocrespotoubes.ui.components.image.SpotifyAsyncImage
import com.sergiocrespotoubes.ui.components.loading.ShowSpotifyEmptyList
import com.sergiocrespotoubes.ui.components.loading.SpotifySpinnerLoading
import com.sergiocrespotoubes.ui.components.showToastError
import com.sergiocrespotoubes.ui.theme.SpotifyDimen
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun ArtistDetailScreen(
    artistId: String,
    artistDetailViewModel: ArtistDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val navController = rememberNavController()

    LaunchedEffect(Unit) {
        artistDetailViewModel.getArtist(artistId)
        artistDetailViewModel.getArtistTracks(artistId)
    }
    val state by artistDetailViewModel.state.collectAsState()
    Design(state, onBackClick)
    ReadEvents(artistDetailViewModel)
}

@Composable
private fun Design(
    state: ArtistDetailViewModel.State,
    onBackClick: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        SpotifyToolbar(
            state.artist?.name ?: "",
            onBackClick = {
                onBackClick()
            },
        )
        Header(state.artist)
        Tracks(state.tracksState)
    }
}

@Composable
private fun Header(artist: ArtistModel?) {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        SpotifyAsyncImage(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .semantics {
                        invisibleToUser()
                    },
            model = artist?.urlPicture,
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.placeholder),
        )
        SpotifyTextTitleBold(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SpotifyDimen.spaceMedium())
                    .padding(top = SpotifyDimen.spaceMedium()),
            text = artist?.name ?: "",
            maxLines = 1,
        )
    }
}

@Composable
fun Tracks(tracksState: ArtistDetailViewModel.TracksState) {
    when (tracksState) {
        ArtistDetailViewModel.TracksState.Error -> ShowTracksError()
        ArtistDetailViewModel.TracksState.Loading -> ShowTracksLoading()
        is ArtistDetailViewModel.TracksState.Success -> {
            if (tracksState.tracks.isEmpty())
                {
                    ShowTracksEmpty()
                } else {
                TracksList(tracksState.tracks)
            }
        }
    }
}

@Composable
fun ShowTracksError() {
    ShowSpotifyError()
}

@Composable
fun ShowTracksEmpty() {
    ShowSpotifyEmptyList()
}

@Composable
fun ShowTracksLoading() {
    SpotifySpinnerLoading(true)
}

@Composable
fun TracksList(tracks: List<TrackModel>) {
    LazyColumn(
        modifier = Modifier.padding(vertical = SpotifyDimen.spaceMedium()),
    ) {
        tracks.forEach { track ->
            item {
                TrackItem(track)
            }
        }
        item {
            Spacer(modifier = Modifier.height(SpotifyDimen.spaceBig()))
        }
    }
}

@Composable
fun ReadEvents(artistDetailViewModel: ArtistDetailViewModel) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        artistDetailViewModel.event.collect { event ->
            when (event) {
                ArtistDetailViewModel.Event.ShowError -> showToastError(context)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtistDetailScreenPreview() {
    SpotifyTheme {
        Design(
            ArtistDetailViewModel.State(
                artist =
                    ArtistModel(
                        id = "1",
                        name = "Name",
                        urlPicture = "",
                        popularity = 1,
                    ),
            ),
            onBackClick = {},
        )
    }
}
