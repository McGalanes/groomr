package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.core.ui.component.Input
import com.github.mcgalanes.groomr.core.ui.component.VerticalSpacer
import com.github.mcgalanes.groomr.feature.userstory.create.R
import com.github.mcgalanes.groomr.feature.userstory.create.ui.CreateUserStoryViewModel
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.AdviceSection


@Composable
fun SolutionForm(
    modifier: Modifier = Modifier,
    viewModel: CreateUserStoryViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SolutionForm(
        modifier = modifier,
        solution = uiState.solution,
        onSolutionChange = viewModel::onSolutionChange,
    )
}

@Composable
private fun SolutionForm(
    solution: String,
    onSolutionChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Form(
        modifier = modifier,
        title = stringResource(R.string.userstory_create_solution_form_title),
    ) {
        Column {
            Text(
                text = stringResource(R.string.userstory_create_solution_form_subtitle),
                style = MaterialTheme.typography.titleSmall,
            )

            VerticalSpacer(24.dp)

            Input(
                modifier = Modifier.fillMaxWidth(),
                value = solution,
                onValueChange = onSolutionChange,
            )

            VerticalSpacer(24.dp)

            AdviceSection(
                advices = mapOf(
                    stringResource(R.string.userstory_create_solution_form_advice_1_title) to stringResource(R.string.userstory_create_solution_form_advice_1_description),
                    stringResource(R.string.userstory_create_solution_form_advice_2_title) to stringResource(R.string.userstory_create_solution_form_advice_2_description),
                ),
            )
        }
    }
}


@Preview
@Composable
private fun SolutionFormPreview() {
    GroomrTheme {
        SolutionForm(
            solution = "",
            onSolutionChange = {},
        )
    }
}
