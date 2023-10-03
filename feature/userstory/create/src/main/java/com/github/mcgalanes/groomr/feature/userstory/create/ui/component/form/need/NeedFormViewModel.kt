package com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.need

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NeedFormViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState.Default)
    val uiState = _uiState.asStateFlow()

    fun onPersonChange(persona: String) =
        _uiState.update { it.copy(persona = persona) }

    fun onWishChange(wish: String) =
        _uiState.update { it.copy(wish = wish) }

    fun onPurposeChange(purpose: String) =
        _uiState.update { it.copy(purpose = purpose) }
}

data class UiState(
    val persona: String,
    val wish: String,
    val purpose: String,
) {
    companion object {
        val Default =
            UiState(
                persona = "",
                wish = "",
                purpose = "",
            )
    }
}
