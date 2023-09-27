package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
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
                Box(
                    modifier = Modifier.height(200.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = "Header content")
                }
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
    val pxStart = with(LocalDensity.current) { 0.dp.toPx() }
    val pxEnd = with(LocalDensity.current) { 250.dp.toPx() }

    Column(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer,
                    ),
                    startY = pxStart,
                    endY = pxEnd,
                ),
            )
            .statusBarsPadding(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 64.dp),
            contentAlignment = Alignment.Center,
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
