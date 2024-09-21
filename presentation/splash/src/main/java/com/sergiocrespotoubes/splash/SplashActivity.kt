package com.sergiocrespotoubes.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text

@Composable
fun SplashScreen() {
    Text(
        text = "Hello Hola!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SplashScreen()
}