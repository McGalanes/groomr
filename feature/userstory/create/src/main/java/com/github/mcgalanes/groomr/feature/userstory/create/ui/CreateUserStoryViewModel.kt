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
}

data class UiState(
    val currentStep: GroomStep,
    val title: String,
) {
    companion object {
        val Default =
            UiState(
                currentStep = GroomStep.Need,
                title = "",
            )
    }
}
