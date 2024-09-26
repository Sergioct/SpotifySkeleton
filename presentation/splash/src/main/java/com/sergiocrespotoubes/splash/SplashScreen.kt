package com.sergiocrespotoubes.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getString
import coil.compose.AsyncImage
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifyTextTitleBold
import com.sergiocrespotoubes.ui.theme.SpotifyDimen
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun SplashScreen(
    //splashViewModel: SplashViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()){
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SpotifyTheme {
        SplashScreen()
    }
}