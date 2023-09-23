package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.modifier.doubleBorder

@Composable
fun DrawerForm(
    title: String,
    expanded: Boolean,
    expandedContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.doubleBorder(color = MaterialTheme.colorScheme.primary),
    ) {
        AnimatedVisibility(
            visible = !expanded,
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut(spring(stiffness = Spring.StiffnessMedium)),
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
            },
        )

        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut(spring(stiffness = Spring.StiffnessMedium)) + shrinkVertically(),
            content = { expandedContent() },
        )
    }
}
