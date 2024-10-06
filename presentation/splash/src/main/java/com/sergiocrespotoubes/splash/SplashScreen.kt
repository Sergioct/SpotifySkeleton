package com.sergiocrespotoubes.splash

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getString
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifyButton
import com.sergiocrespotoubes.ui.components.SpotifyTextTitleBold
import com.sergiocrespotoubes.ui.theme.SpotifyDimen
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel = hiltViewModel(),
    navigateToArtistSearch: () -> Unit,
) {
    val context = LocalContext.current
    val state = splashViewModel.state.collectAsState().value
    Design(
        context,
        state = state,
        onRetryClick = { splashViewModel.onRetryClick() }
    )
    ReadEvents(
        splashViewModel = splashViewModel,
        navigateToArtistSearch = navigateToArtistSearch,
    )
}

@Composable
private fun Design(
    context: Context,
    state: SplashViewModel.State,
    onRetryClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = SpotifyDimen.spaceBig())
        ) {
            AsyncImage(
                model = R.drawable.splash_spotify,
                contentDescription = null,
            )
            SpotifyTextTitleBold(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = SpotifyDimen.spaceMedium()),
                text = getString(context, R.string.app_name)
            )
            if(state == SplashViewModel.State.Idle){
                SpotifyButton(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = SpotifyDimen.spaceBig())
                        .wrapContentSize(),
                    text = "Reintentar",
                    onCLick = { onRetryClick() }
                )
            }
        }
    }
}

@Composable
fun ReadEvents(
    splashViewModel: SplashViewModel,
    navigateToArtistSearch: () -> Unit,
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        splashViewModel.event.collect { event ->
            when (event) {
                is SplashViewModel.Event.NavigateToArtistSearch -> {
                    navigateToArtistSearch()
                }
                SplashViewModel.Event.ShowError -> Toast.makeText(
                    context,
                    "Error",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SpotifyTheme {
        SplashScreen(
            navigateToArtistSearch = {}
        )
    }
}