package com.github.mcgalanes.groomr.core.domain.fake

import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class FakeUserStoryRepository : UserStoryRepository {

    private val userStoriesFlow = MutableStateFlow(emptyList<UserStory>())

    override fun getUserStories(): Flow<List<UserStory>> = userStoriesFlow

    override fun getUserStory(id: Long): Flow<UserStory> =
        userStoriesFlow.map { userStories -> userStories.first { it.id == id } }

    override suspend fun createUserStory(userStory: UserStory) =
        userStoriesFlow.update { it + userStory }
}
