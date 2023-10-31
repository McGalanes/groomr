package com.github.mcgalanes.groomr.feature.userstory.list.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.ui.GroomrTheme
import com.github.mcgalanes.groomr.feature.userstory.list.ui.component.UserStoryItem
import kotlinx.collections.immutable.persistentListOf

@Preview
@Composable
private fun UserStoryListScreenPreview() {
    GroomrTheme {
        UserStoryListScreen(
            modifier = Modifier.fillMaxSize(),
            state = UiState.Default.copy(
                userStories = persistentListOf(
                    UserStory(
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
                        criterias = emptyList(),
                    ),
                    UserStory(
                        id = 1L,
                        title = "My second User Story",
                        persona = "",
                        wish = "",
                        purpose = "",
                        kpi = "",
                        businessValue = 100,
                        solution = "",
                        enablers = "",
                        assets = "",
                        estimation = 13,
                        smallEnough = true,
                        independent = true,
                        estimable = true,
                        testable = true,
                        criterias = emptyList(),
                    ),
                ),
            ),
        )
    }
}

@Composable
fun UserStoryListScreen(
    modifier: Modifier = Modifier,
    viewModel: UserStoryListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    UserStoryListScreen(
        modifier = modifier,
        state = uiState,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun UserStoryListScreen(
    state: UiState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        stickyHeader {
            Text(
                modifier = Modifier.padding(bottom = 24.dp),
                text = "User Stories",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        items(state.userStories) { userStory ->
            UserStoryItem(
                title = userStory.title,
                estimation = userStory.estimation,
            )
        }
    }
}
