package com.github.mcgalanes.groomr.feature.userstory.create.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.feature.userstory.create.domain.GroomStep
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.CreateUserStoryHeader
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.FormStepper
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.need.NeedForm

@Preview
@Composable
private fun CreateUserStoryScreenPreview() {
    GroomrTheme {
        CreateUserStoryScreen(
            modifier = Modifier.fillMaxSize(),
            state = UiState.Default,
            onTitleChange = {},
            onStepTabClick = {},
        )
    }
}

@Composable
fun CreateUserStoryScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateUserStoryViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CreateUserStoryScreen(
        modifier = modifier.fillMaxSize(),
        state = uiState,
        onTitleChange = viewModel::onTitleChange,
        onStepTabClick = viewModel::onStepTabClick,
    )
}

@Composable
private fun CreateUserStoryScreen(
    state: UiState,
    onTitleChange: (String) -> Unit,
    onStepTabClick: (GroomStep) -> Unit,
    modifier: Modifier = Modifier,
) {
    FormStepper(
        modifier = modifier,
        headerContent = {
            CreateUserStoryHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 12.dp),
                currentStep = state.currentStep,
                titleValue = state.title,
                onTitleValueChange = onTitleChange,
                onStepTabClick = onStepTabClick,
            )
        },
    ) {
        Crossfade(
            targetState = state.currentStep,
            label = "stepper_form_crossfade",
        ) { step ->
            when (step) {
                GroomStep.Need -> {
                    NeedForm(
                        modifier = Modifier.padding(16.dp), //extract to parent
                    )
                }

                else -> Unit
            }
        }
    }
}
