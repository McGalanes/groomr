package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.kpi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class KpiFormViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState.Default)
    val uiState = _uiState.asStateFlow()

    fun onKpiChange(kpi: String) {
        _uiState.update { it.copy(kpi = kpi) }
    }
}

data class UiState(
    val kpi: String,
) {
    companion object {
        val Default = UiState(kpi = "")
    }
}
