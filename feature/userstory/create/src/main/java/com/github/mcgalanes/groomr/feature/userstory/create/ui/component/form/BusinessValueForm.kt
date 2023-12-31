package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
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
fun BusinessValueForm(
    modifier: Modifier = Modifier,
    viewModel: CreateUserStoryViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BusinessValueForm(
        modifier = modifier,
        businessValue = uiState.businessValue,
        onBusinessValueChange = viewModel::onBusinessValueChange,
    )
}

@Composable
private fun BusinessValueForm(
    businessValue: Int,
    modifier: Modifier = Modifier,
    onBusinessValueChange: (Int?) -> Unit,
) {
    Form(
        modifier = modifier,
        title = stringResource(R.string.userstory_create_business_value_form_title),
    ) {
        Column {
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = businessValue.toString(),
                onValueChange = { onBusinessValueChange(it.toIntOrNull()) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

            VerticalSpacer(24.dp)

            AdviceSection(
                modifier = modifier,
                advices = mapOf(
                    stringResource(R.string.userstory_create_business_value_form_advice_title) to stringResource(R.string.userstory_create_business_value_form_advice_description),
                ),
            )
        }
    }
}

@Preview
@Composable
private fun BusinessValueFormPreview() {
    GroomrTheme {
        BusinessValueForm(
            modifier = Modifier.fillMaxWidth(),
            businessValue = 0,
            onBusinessValueChange = {},
        )
    }
}
