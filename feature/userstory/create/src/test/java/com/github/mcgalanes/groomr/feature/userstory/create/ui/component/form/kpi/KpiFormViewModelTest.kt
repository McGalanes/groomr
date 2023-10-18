package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.kpi

import org.junit.Assert.assertEquals
import org.junit.Test

class KpiFormViewModelTest {

    private val viewModel = KpiFormViewModel()

    @Test
    fun `on kpi change, should update kpi`() {
        //GIVEN
        val kpi = "I can better report our success and failures"

        //WHEN
        viewModel.onKpiChange(kpi)

        //THEN
        assertEquals(kpi, viewModel.uiState.value.kpi)
    }
}
