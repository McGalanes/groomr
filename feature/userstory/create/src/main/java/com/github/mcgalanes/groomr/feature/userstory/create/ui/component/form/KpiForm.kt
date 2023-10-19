package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun KpiForm(
    modifier: Modifier = Modifier,
    viewModel: CreateUserStoryViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    KpiForm(
        modifier = modifier,
        kpi = uiState.kpi,
        onKpiChange = viewModel::onKpiChange,
    )
}

@Composable
private fun KpiForm(
    kpi: String,
    onKpiChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Form(
        modifier = modifier,
        title = stringResource(R.string.userstory_create_kpi_form_title),
    ) {
        Column {
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = kpi,
                placeholder = stringResource(R.string.userstory_create_kpi_form_placeholder),
                onValueChange = onKpiChange,
            )

            VerticalSpacer(24.dp)

            AdviceSection(
                modifier = modifier,
                advices = mapOf(
                    stringResource(R.string.userstory_create_kpi_form_advice_title) to stringResource(R.string.userstory_create_kpi_form_advice_description),
                ),
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun KpiFormPreview() {
    GroomrTheme {
        var expanded by remember { mutableStateOf(true) }

        KpiForm(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    expanded = !expanded
                },
            kpi = "",
            onKpiChange = {},
        )
    }
}
