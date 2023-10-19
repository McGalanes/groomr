package com.github.mcgalanes.groomr.feature.userstory.create.ui

import androidx.lifecycle.ViewModel
import com.github.mcgalanes.groomr.feature.userstory.create.domain.GroomStep
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateUserStoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState.Default)
    val uiState = _uiState.asStateFlow()

    fun onStepTabClick(step: GroomStep) {
        _uiState.update {
            it.copy(currentStep = step)
        }
    }

    fun onTitleChange(title: String) {
        _uiState.update {
            it.copy(title = title)
        }
    }

    fun onPersonChange(persona: String) =
        _uiState.update { it.copy(persona = persona) }

    fun onWishChange(wish: String) =
        _uiState.update { it.copy(wish = wish) }

    fun onPurposeChange(purpose: String) =
        _uiState.update { it.copy(purpose = purpose) }

    fun onKpiChange(kpi: String) =
        _uiState.update { it.copy(kpi = kpi) }

    fun onBusinessValueChange(businessValue: Int?) =
        _uiState.update { it.copy(businessValue = businessValue ?: 0) }

    fun onSolutionChange(solution: String) {
        _uiState.update { it.copy(solution = solution) }
    }
}

data class UiState(
    val currentStep: GroomStep,
    val title: String,
    val persona: String,
    val wish: String,
    val purpose: String,
    val kpi: String,
    val businessValue: Int,
    val solution: String,
) {
    companion object {
        val Default =
            UiState(
                currentStep = GroomStep.Need,
                title = "",
                persona = "",
                wish = "",
                purpose = "",
                kpi = "",
                businessValue = 0,
                solution = "",
            )
    }
}
