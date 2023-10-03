package com.github.mcgalanes.groomr.feature.userstory.create.ui

import com.github.mcgalanes.groomr.feature.userstory.create.domain.GroomStep
import org.junit.Assert.assertEquals
import org.junit.Test


class CreateUserStoryViewModelTest {

    private val viewModel = CreateUserStoryViewModel()

    @Test
    fun `on step tab click, should select step`() {
        // GIVEN
        val step = GroomStep.entries.random()

        // WHEN
        viewModel.onStepTabClick(step)

        // THEN
        assertEquals(step, viewModel.uiState.value.currentStep)
    }

    @Test
    fun `on title change, should update title`() {
        // GIVEN
        val title = "My user story"

        // WHEN
        viewModel.onTitleChange(title)

        // THEN
        assertEquals(title, viewModel.uiState.value.title)
    }
}
