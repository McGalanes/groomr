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

    @Test
    fun `on persona change, should update persona`() {
        // GIVEN
        val persona = "manager"

        // WHEN
        viewModel.onPersonChange(persona)

        // THEN
        assertEquals(persona, viewModel.uiState.value.persona)
    }

    @Test
    fun `on wish change, should update wish`() {
        // GIVEN
        val wish = "be able to understand my colleagues progress"

        // WHEN
        viewModel.onWishChange(wish)

        // THEN
        assertEquals(wish, viewModel.uiState.value.wish)
    }

    @Test
    fun `on purpose change, should update purpose`() {
        // GIVEN
        val purpose = "I can better report our success and failures"

        // WHEN
        viewModel.onPurposeChange(purpose)

        // THEN
        assertEquals(purpose, viewModel.uiState.value.purpose)
    }

    @Test
    fun `on kpi change, should update kpi`() {
        //GIVEN
        val kpi = "I can better report our success and failures"

        //WHEN
        viewModel.onKpiChange(kpi)

        //THEN
        assertEquals(kpi, viewModel.uiState.value.kpi)
    }

    @Test
    fun `on business value change, should update business value`() {
        //GIVEN
        val businessValue = 100

        //WHEN
        viewModel.onBusinessValueChange(businessValue)

        //THEN
        assertEquals(businessValue, viewModel.uiState.value.businessValue)
    }

    @Test
    fun `on business value change, should update business value to 0 if null`() {
        //GIVEN
        val businessValue = null

        //WHEN
        viewModel.onBusinessValueChange(businessValue)

        //THEN
        assertEquals(0, viewModel.uiState.value.businessValue)
    }

    @Test
    fun `on solution change, should update solution`() {
        //GIVEN
        val solution = "I can better report our success and failures"

        //WHEN
        viewModel.onSolutionChange(solution)

        //THEN
        assertEquals(solution, viewModel.uiState.value.solution)
    }
}
