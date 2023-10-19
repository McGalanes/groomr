package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.component.VerticalSpacer

@Composable
fun Form(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
        )

        VerticalSpacer(24.dp)

        content()
    }
}
