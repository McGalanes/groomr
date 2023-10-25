package com.github.mcgalanes.groomr.core.domain.usecase

import com.github.mcgalanes.groomr.core.domain.fake.FakeUserStoryRepository
import com.github.mcgalanes.groomr.core.domain.fixture.DomainFixtures
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class CreateUserStoryUseCaseTest {

    private lateinit var repository: UserStoryRepository
    private lateinit var useCase: CreateUserStoryUseCase

    @Before
    fun setUp() {
        repository = FakeUserStoryRepository()
        useCase = CreateUserStoryUseCase(repository)
    }

    @Test
    fun `should create user story when success`() = runTest {
        // GIVEN
        val userStory = DomainFixtures.randomUserStory()

        // WHEN
        val result = useCase(userStory)

        // THEN
        Assert.assertTrue(result.isSuccess)
    }

    @Test
    fun `should return error when fail`() = runTest {
        // GIVEN
        val repository =
            object : UserStoryRepository {
                override fun getUserStory(id: Long): Flow<UserStory> = throw NotImplementedError()
                override suspend fun createUserStory(userStory: UserStory) = throw Exception()
            }

        val useCase = CreateUserStoryUseCase(repository)

        val userStory = DomainFixtures.randomUserStory()

        // WHEN
        val result = useCase(userStory)

        // THEN
        Assert.assertTrue(result.isFailure)
    }
}
