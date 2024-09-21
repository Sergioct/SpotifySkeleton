package com.sergiocrespotoubes.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.sergiocrespotoubes.ui.theme.SpotifyTheme

@Composable
fun SplashScreen() {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "SplashScreen")
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SpotifyTheme {
        SplashScreen()
    }
}