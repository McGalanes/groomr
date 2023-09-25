package com.github.mcgalanes.groomr.feature.userstory.create.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.core.ui.component.HorizontalSpacer
import com.github.mcgalanes.groomr.core.ui.component.Input
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
        headerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Input(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        value = "",
                        label = null,
                        placeholder = "My User Story...",
                        onValueChange = {},
                    )

                    HorizontalSpacer(8.dp)

                    TextButton(
                        onClick = {},
                    ) {
                        Text(text = "Cancel", color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
        },
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
