package com.sergiocrespotoubes.songs.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SongListScreen() {
    Text(
        text = "Hello Hola!",
    )
}

@Preview(showBackground = true)
@Composable
fun SongListScreenPreview() {
    SongListScreen()
}