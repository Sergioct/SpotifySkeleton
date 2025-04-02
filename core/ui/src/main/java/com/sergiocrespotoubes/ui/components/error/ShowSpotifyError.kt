package com.sergiocrespotoubes.ui.components.error

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifyPreview
import com.sergiocrespotoubes.ui.components.SpotifyTextBig
import com.sergiocrespotoubes.ui.components.image.SpotifyIconImage
import com.sergiocrespotoubes.ui.theme.SpotifyDimen

@Composable
fun ShowSpotifyError(modifier: Modifier = Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(all = SpotifyDimen.spaceBig()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SpotifyIconImage(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .width(96.dp)
                    .height(96.dp),
            imageVector = Icons.Filled.Warning,
            contentDescription = stringResource(R.string.common_error),
            color = MaterialTheme.colorScheme.error,
        )
        SpotifyTextBig(
            Modifier
                .padding(top = SpotifyDimen.spaceBig())
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.common_error),
            textAlign = TextAlign.Center,
        )
    }
}

@SpotifyPreview
@Composable
fun ShowSpotifyErrorPreview() {
    ShowSpotifyError()
}
