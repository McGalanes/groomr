package com.github.mcgalanes.groomr.feature.userstory.create.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.CreateUserStoryHeader
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.FormStepper
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.NeedForm

@Preview
@Composable
private fun CreateUserStoryScreenPreview() {
    GroomrTheme {
        CreateUserStoryScreen(
            modifier = Modifier.fillMaxSize(),
            onBackClick = {},
        )
    }
}

@Composable
fun CreateUserStoryScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FormStepper(
        modifier = modifier,
        headerContent = {
            CreateUserStoryHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 12.dp),
                titleValue = "",
                onTitleValueChange = { TODO() },
                onStepTabClick = { TODO() },
                onBackClick = onBackClick,
            )
        },
    ) {
        NeedForm(
            modifier = Modifier.padding(16.dp),
            personaValue = "",
            wishValue = "",
            purposeValue = "",
            onPersonaChange = { TODO() },
            onWishChange = { TODO() },
            onPurposeChange = { TODO() },
        )
    }
}
