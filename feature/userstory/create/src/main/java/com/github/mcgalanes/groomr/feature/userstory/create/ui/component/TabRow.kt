package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.feature.userstory.create.domain.GroomStep

@Preview(showBackground = true)
@Composable
private fun TabRowPreview() {
    GroomrTheme {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            steps = GroomStep.entries.toTypedArray(),
            selected = GroomStep.entries[2],
            onItemClick = {},
        )
    }
}

@Composable
fun TabRow(
    steps: Array<GroomStep>,
    selected: GroomStep,
    onItemClick: (GroomStep) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 8.dp),
    ) {
        items(steps) { step ->
            TabItem(
                label = step.name,
                selected = step == selected,
                onClick = { onItemClick(step) },
            )
        }
    }
}
