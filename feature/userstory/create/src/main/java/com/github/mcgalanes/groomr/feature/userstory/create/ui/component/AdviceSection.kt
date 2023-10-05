package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.core.ui.component.HorizontalSpacer
import com.github.mcgalanes.groomr.core.ui.component.VerticalSpacer
import com.github.mcgalanes.groomr.core.ui.token.shape.squircle.SquircleShape
import com.github.mcgalanes.groomr.feature.userstory.create.R

@Preview(showSystemUi = true)
@Composable
private fun AdviceSectionPreview() {
    GroomrTheme {
        AdviceSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            advices = mapOf(
                "Advice n°1" to "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",
                "Advice n°2" to "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",
                "Advice n°3" to "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",
            ),
        )
    }
}

typealias AdviceTitle = String
typealias AdviceDescription = String

@Composable
fun AdviceSection(
    advices: Map<AdviceTitle, AdviceDescription>,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier,
        shape = SquircleShape(radius = 24.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { expanded = !expanded },
                )
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                    )

                    HorizontalSpacer(8.dp)

                    Text(
                        text = stringResource(R.string.userstory_create_advice_section_title),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column {
                    VerticalSpacer(24.dp)

                    advices.onEachIndexed { index, (title, description) ->
                        AdviceLine(
                            title = title,
                            description = description,
                        )

                        if (index < advices.size) VerticalSpacer(16.dp)
                    }
                }
            }
        }
    }
}

@Composable
private fun AdviceLine(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
        )

        VerticalSpacer(8.dp)

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = description,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
