package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme

@Preview(showBackground = true)
@Composable
private fun TabItemPreview() {
    Column {
        GroomrTheme(darkTheme = false) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TabItem(
                    label = "TabItem",
                    selected = true,
                    onClick = {},
                )
                TabItem(
                    label = "TabItem",
                    selected = false,
                    onClick = {},
                )
            }
        }

        GroomrTheme(darkTheme = true) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TabItem(
                    label = "TabItem",
                    selected = true,
                    onClick = {},
                )
                TabItem(
                    label = "TabItem",
                    selected = false,
                    onClick = {},
                )
            }
        }
    }
}

@Composable
fun TabItem(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = Color.White.copy(alpha = .9f)

    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .then(
                if (selected)
                    Modifier.background(backgroundColor)
                else
                    Modifier,
            )
            .padding(vertical = 6.dp, horizontal = 12.dp),

        ) {
        Text(
            text = label,
            style = if (selected) {
                MaterialTheme.typography.labelLarge
            } else {
                MaterialTheme.typography.bodyMedium
            },
            color = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                Color.White
            },
        )
    }
}
