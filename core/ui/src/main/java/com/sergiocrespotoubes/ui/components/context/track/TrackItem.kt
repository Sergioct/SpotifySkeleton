package com.sergiocrespotoubes.ui.components.context.track

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.SpotifyTextMedium
import com.sergiocrespotoubes.ui.components.SpotifyTextSmall
import com.sergiocrespotoubes.ui.components.image.SpotifyAsyncImage
import com.sergiocrespotoubes.ui.theme.SpotifyDimen

@Composable
fun TrackItem(track: TrackModel) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = SpotifyDimen.spaceMedium())
                .padding(bottom = SpotifyDimen.spaceMedium()),
    ) {
        SpotifyAsyncImage(
            modifier =
                Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .semantics {
                        invisibleToUser()
                    },
            model = track.urlPicture,
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.placeholder),
        )
        Column(
            modifier =
                Modifier
                    .padding(start = SpotifyDimen.spaceMedium())
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
        ) {
            SpotifyTextMedium(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                text = track.name,
                maxLines = 1,
            )
            SpotifyTextSmall(
                modifier =
                    Modifier
                        .padding(top = SpotifyDimen.spaceSmall())
                        .fillMaxWidth(),
                text = track.name,
                maxLines = 1,
            )
        }
    }
}
