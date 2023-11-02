package com.github.mcgalanes.groomr.feature.userstory.list.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.core.ui.component.VerticalSpacer

@Preview(showSystemUi = true)
@Composable
private fun UserStoryItemPreview() {
    GroomrTheme {
        UserStoryItem(
            modifier = Modifier.padding(16.dp),
            userStory = UserStory(
                id = 1L,
                title = "My first User Story",
                persona = "",
                wish = "",
                purpose = "",
                kpi = "",
                businessValue = 100,
                solution = "",
                enablers = "",
                assets = "",
                estimation = 8,
                smallEnough = true,
                independent = true,
                estimable = true,
                testable = true,
                criterias = listOf(
                    UserStory.Criteria(
                        id = 1L,
                        title = "My first criteria",
                        gherkinLines = emptyList(),
                    ),
                    UserStory.Criteria(
                        id = 1L,
                        title = "My first criteria",
                        gherkinLines = emptyList(),
                    ),
                    UserStory.Criteria(
                        id = 1L,
                        title = "My first criteria",
                        gherkinLines = emptyList(),
                    ),
                ),
            ),
        )
    }
}

@Composable
fun UserStoryItem(
    userStory: UserStory,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        shadowElevation = 2.dp,
        shape = MaterialTheme.shapes.small,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier.padding(6.dp),
                text = userStory.title,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Divider(Modifier.height(0.5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
            ) {
                InfoBox(
                    title = "Criterias",
                    value = userStory.criterias.count().toString(),
                )

                VerticalDivider()

                InfoBox(
                    title = "Estimation",
                    value = userStory.estimation.toString(),
                )

                VerticalDivider()

                InfoBox(
                    title = "Business Value",
                    value = userStory.businessValue.toString(),
                )

                VerticalDivider()

                InfoBox(
                    title = "Ready",
                    value = "yes"
                )
            }
        }
    }
}

@Composable
private fun InfoBox(
    title: String,
    modifier: Modifier = Modifier,
    value: String? = null,
    valueContent: @Composable () -> Unit = {},
) {
    Column(
        modifier = modifier.padding(6.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface,
        )

        VerticalSpacer(8.dp)

        value?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        } ?: valueContent()
    }
}

@Composable
private fun VerticalDivider(
    modifier: Modifier = Modifier,
) {
    Divider(
        modifier = modifier
            .fillMaxHeight()
            .width(0.5.dp),
        color = DividerDefaults.color,
    )
}
