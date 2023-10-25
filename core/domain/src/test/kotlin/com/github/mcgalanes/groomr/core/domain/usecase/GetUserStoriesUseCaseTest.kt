package com.github.mcgalanes.groomr.core.domain.usecase

import com.github.mcgalanes.groomr.core.domain.fake.FakeUserStoryRepository
import com.github.mcgalanes.groomr.core.domain.fixture.DomainFixtures
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class GetUserStoriesUseCaseTest {

    @Test
    fun `should return user stories`() = runTest {
        // GIVEN
        val repository: UserStoryRepository = FakeUserStoryRepository()
        val useCase = GetUserStoriesUseCase(repository)

        val userStories =
            List(5) { DomainFixtures.randomUserStory() }
                .onEach { repository.createUserStory(it) }

        // WHEN
        val actual = useCase()

        // THEN
        assertEquals(userStories, actual.first())
    }
}
