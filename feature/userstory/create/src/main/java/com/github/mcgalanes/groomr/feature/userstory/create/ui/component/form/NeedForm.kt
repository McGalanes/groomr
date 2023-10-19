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
fun NeedForm(
    modifier: Modifier = Modifier,
    viewModel: CreateUserStoryViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NeedForm(
        modifier = modifier,
        persona = uiState.persona,
        wish = uiState.wish,
        purpose = uiState.purpose,
        onPersonaChange = viewModel::onPersonChange,
        onWishChange = viewModel::onWishChange,
        onPurposeChange = viewModel::onPurposeChange,
    )
}

@Composable
private fun NeedForm(
    persona: String,
    wish: String,
    purpose: String,
    onPersonaChange: (String) -> Unit,
    onWishChange: (String) -> Unit,
    onPurposeChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Form(
        modifier = modifier,
        title = stringResource(R.string.userstory_create_need_form_title),
    ) {
        Column {
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = persona,
                placeholder = stringResource(R.string.userstory_create_need_form_persona_placeholder),
                onValueChange = onPersonaChange,
            )

            VerticalSpacer(8.dp)

            Input(
                modifier = Modifier.fillMaxWidth(),
                value = wish,
                placeholder = stringResource(R.string.userstory_create_need_form_wish_placeholder),
                onValueChange = onWishChange,
            )

            VerticalSpacer(8.dp)

            Input(
                modifier = Modifier.fillMaxWidth(),
                value = purpose,
                placeholder = stringResource(R.string.userstory_create_need_form_purpose_placeholder),
                onValueChange = onPurposeChange,
            )

            VerticalSpacer(24.dp)

            AdviceSection(
                modifier = modifier,
                advices = mapOf(
                    stringResource(R.string.userstory_create_need_form_advice_1_title) to stringResource(R.string.userstory_create_need_form_advice_1_description),
                    stringResource(R.string.userstory_create_need_form_advice_2_title) to stringResource(R.string.userstory_create_need_form_advice_2_description),
                    stringResource(R.string.userstory_create_need_form_advice_3_title) to stringResource(R.string.userstory_create_need_form_advice_3_description),
                ),
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun NeedFormPreview() {
    GroomrTheme {
        var expanded by remember { mutableStateOf(true) }

        NeedForm(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    expanded = !expanded
                },
            persona = "",
            wish = "",
            purpose = "",
            onPersonaChange = {},
            onWishChange = {},
            onPurposeChange = {},
        )
    }
}
