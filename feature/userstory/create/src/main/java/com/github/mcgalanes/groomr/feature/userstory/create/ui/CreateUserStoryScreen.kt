package com.github.mcgalanes.groomr.feature.userstory.create.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.FormStepper
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.NeedForm

@Preview
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
    FormStepper(
        modifier = modifier,
        headerContent = {},
    ) {
        NeedForm(
            modifier = Modifier.padding(16.dp),
            personaValue = "",
            wishValue = "",
            purposeValue = "",
            onPersonaChange = {},
            onWishChange = {},
            onPurposeChange = {},
        )
    }
}
