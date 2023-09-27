package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.component.HorizontalSpacer
import com.github.mcgalanes.groomr.core.ui.component.VerticalSpacer
import com.github.mcgalanes.groomr.feature.userstory.create.R
import com.github.mcgalanes.groomr.feature.userstory.create.domain.GroomStep

@Composable
fun CreateUserStoryHeader(
    titleValue: String,
    onTitleValueChange: (String) -> Unit,
    onStepTabClick: (GroomStep) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .padding(end = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = onBackClick,
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBackIosNew,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null,
                )
            }

            HorizontalSpacer(16.dp)

            TitleInput(
                modifier = Modifier.fillMaxWidth(),
                value = titleValue,
                placeholder = stringResource(R.string.userstory_create_user_story_title_placeholder),
                onValueChange = onTitleValueChange,
            )
        }

        VerticalSpacer(16.dp)

        TabRow(
            steps = GroomStep.entries.toTypedArray(),
            selected = GroomStep.Kpi,
            onItemClick = onStepTabClick,
        )
    }
}
