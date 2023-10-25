package com.github.mcgalanes.groomr.core.domain.usecase

import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import javax.inject.Inject

class CreateUserStoryUseCase
@Inject constructor(
    private val repository: UserStoryRepository,
) {
    
    suspend operator fun invoke(userStory: UserStory): Result<Unit> =
        Result.runCatching { repository.createUserStory(userStory) }
}
