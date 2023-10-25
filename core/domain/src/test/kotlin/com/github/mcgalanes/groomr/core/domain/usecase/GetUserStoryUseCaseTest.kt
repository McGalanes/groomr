package com.github.mcgalanes.groomr.core.domain.usecase

import com.github.mcgalanes.groomr.core.domain.fake.FakeUserStoryRepository
import com.github.mcgalanes.groomr.core.domain.fixture.DomainFixtures
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class GetUserStoryUseCaseTest {

    @Test
    fun `should return user story`() = runTest {
        // GIVEN
        val repository: UserStoryRepository = FakeUserStoryRepository()
        val useCase = GetUserStoryUseCase(repository)

        val userStory = DomainFixtures.randomUserStory()
        repository.createUserStory(userStory)

        // WHEN
        val result = useCase(userStory.id)

        // THEN
        assertEquals(userStory, result.first())
    }
}
