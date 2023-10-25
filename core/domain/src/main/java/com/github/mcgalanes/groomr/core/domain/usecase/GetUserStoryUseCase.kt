package com.github.mcgalanes.groomr.core.domain.usecase

import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserStoryUseCase
@Inject constructor(
    private val repository: UserStoryRepository,
) {

    operator fun invoke(id: Long): Flow<UserStory> =
        repository.getUserStory(id)
}
