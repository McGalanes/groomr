package com.github.mcgalanes.groomr.core.domain.repository

import com.github.mcgalanes.groomr.core.domain.model.UserStory
import kotlinx.coroutines.flow.Flow

interface UserStoryRepository {
    fun getUserStory(id: Long): Flow<UserStory>

    suspend fun createUserStory(userStory: UserStory)
}
