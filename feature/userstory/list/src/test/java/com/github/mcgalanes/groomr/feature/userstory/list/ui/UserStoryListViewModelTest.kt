package com.github.mcgalanes.groomr.feature.userstory.list.ui

import com.github.mcgalanes.groomr.core.domain.fixture.DomainFixtures
import com.github.mcgalanes.groomr.core.domain.usecase.GetUserStoriesUseCase
import com.github.mcgalanes.groomr.core.testing.MainDispatcherRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


class UserStoryListViewModelTest {

    @get:Rule val dispatcherRule = MainDispatcherRule()
    private val getUserStories: GetUserStoriesUseCase = mockk()

    @Test
    fun `on init, should show user stories`() {
        // GIVEN
        val userStories = List(3) { DomainFixtures.randomUserStory() }
        every { getUserStories() } returns flowOf(userStories)

        // WHEN
        val viewModel = UserStoryListViewModel(getUserStories)

        // THEN
        Assert.assertEquals(
            userStories,
            viewModel.uiState.value.userStories,
        )
    }
}
