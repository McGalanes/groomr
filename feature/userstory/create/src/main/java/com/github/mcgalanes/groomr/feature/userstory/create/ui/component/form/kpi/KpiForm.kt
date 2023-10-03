package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.kpi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.core.ui.component.Input
import com.github.mcgalanes.groomr.core.ui.component.VerticalSpacer
import com.github.mcgalanes.groomr.feature.userstory.create.R

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
            kpiValue = "",
            onKpiChange = {},
        )
    }
}

@Composable
fun KpiForm(
    kpiValue: String,
    onKpiChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(R.string.userstory_create_kpi_form_title),
            style = MaterialTheme.typography.titleMedium,
        )

        VerticalSpacer(24.dp)

        Input(
            modifier = Modifier.fillMaxWidth(),
            value = kpiValue,
            placeholder = stringResource(R.string.userstory_create_kpi_form_placeholder),
            onValueChange = onKpiChange,
        )
    }
}
