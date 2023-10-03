package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.need

import org.junit.Assert.assertEquals
import org.junit.Test

class NeedFormViewModelTest {

    private val viewModel = NeedFormViewModel()

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
}
