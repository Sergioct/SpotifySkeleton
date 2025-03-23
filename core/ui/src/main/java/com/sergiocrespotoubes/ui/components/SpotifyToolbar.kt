package com.sergiocrespotoubes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sergiocrespotoubes.ui.R
import com.sergiocrespotoubes.ui.components.buttons.SpotifyIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotifyToolbar(
    title: String,
    onBackClick: (() -> Unit)? = null,
) {
    TopAppBar(
        modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        title = {
            SpotifyTextSubtitleBold(
                text = title,
                maxLines = 1,
            )
        },
        colors =
            TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
        navigationIcon = {
            if (onBackClick != null) {
                SpotifyIconButton(
                    modifier = Modifier,
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.common_back),
                    onClick = onBackClick,
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        },
    )
}
