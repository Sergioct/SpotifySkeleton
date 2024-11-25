package com.sergiocrespotoubes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SpotifyTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    label: String = "Label",
    leadingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(label) },
        leadingIcon = { leadingIcon?.let {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "Search",
                )
            }
        }
    )
}

@Composable
@Preview
fun SpotifyTextFieldPreview(
    modifier: Modifier = Modifier,
) {
    SpotifyTextField(
        modifier = modifier
            .fillMaxWidth(),
        onValueChange = {}
    )
}