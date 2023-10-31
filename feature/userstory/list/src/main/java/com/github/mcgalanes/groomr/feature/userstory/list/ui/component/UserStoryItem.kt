package com.github.mcgalanes.groomr.feature.userstory.list.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme

@Preview
@Composable
private fun UserStoryItemPreview() {
    GroomrTheme {
        UserStoryItem(
            title = "My first user story",
            estimation = 8,
        )
    }
}

@Composable
fun UserStoryItem(
    title: String,
    estimation: Int,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        shadowElevation = 1.dp,
        shape = MaterialTheme.shapes.large,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(vertical = 4.dp, horizontal = 8.dp),
            ) {
                Text(
                    text = estimation.toString(),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
        }
    }
}
