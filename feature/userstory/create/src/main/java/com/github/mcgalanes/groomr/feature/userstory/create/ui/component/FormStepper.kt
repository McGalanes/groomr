package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme

@Preview
@Composable
private fun FormStepperPreview() {
    GroomrTheme {
        FormStepper(
            headerContent = {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Header content",
                )
            },
        ) {
            Box {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Sheet content here",
                )
            }
        }
    }
}

@Composable
fun FormStepper(
    modifier: Modifier = Modifier,
    sheetRadius: Dp = 16.dp,
    headerContent: @Composable BoxScope.() -> Unit,
    sheetContent: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 64.dp),
            ) {
                headerContent()
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = sheetRadius, topEnd = sheetRadius),
            ) {
                sheetContent()
            }
        }
    }
}
