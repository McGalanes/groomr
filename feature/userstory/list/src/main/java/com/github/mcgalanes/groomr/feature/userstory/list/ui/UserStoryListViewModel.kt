package com.github.mcgalanes.groomr.feature.userstory.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.usecase.GetUserStoriesUseCase
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserStoryListViewModel
@Inject constructor(
    getUserStories: GetUserStoriesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState.Default)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getUserStories()
                .map(List<UserStory>::toImmutableList)
                .collect { userStories ->
                    _uiState.update {
                        it.copy(userStories = userStories)
                    }
                }
        }
    }
}

data class UiState(
    val userStories: ImmutableList<UserStory>,
) {
    companion object {
        val Default = UiState(userStories = persistentListOf())
    }
}
