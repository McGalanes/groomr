package com.github.mcgalanes.groomr.feature.userstory.create.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.NeedForm

@Preview(showSystemUi = true)
@Composable
private fun CreateUserStoryScreenPreview() {
    GroomrTheme {
        CreateUserStoryScreen(Modifier.fillMaxSize())
    }
}

@Composable
fun CreateUserStoryScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NeedForm(
            personaValue = "",
            wishValue = "",
            purposeValue = "",
            expanded = true,
            onPersonaChange = {},
            onWishChange = {},
            onPurposeChange = {},
        )
        Button(
            onClick = {},
        ) {
            Text(text = "Allez ooooof")
        }
    }
}
