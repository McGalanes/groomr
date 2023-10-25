package com.github.mcgalanes.groomr.core.data

import com.github.mcgalanes.groomr.core.data.fake.FakeUserStoryDao
import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import com.github.mcgalanes.groomr.core.domain.fixture.DomainFixtures
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DefaultUserStoryRepositoryTest {

    private lateinit var dao: UserStoryDao
    private lateinit var repository: UserStoryRepository

    @Before
    fun setUp() {
        dao = FakeUserStoryDao()
        repository = DefaultUserStoryRepository(dao)
    }

    @Test
    fun `get user stories, should return user stories`() = runTest {
        // GIVEN
        val userStories =
            List(5) {
                DomainFixtures.randomUserStory()
            }.onEach { repository.createUserStory(it) }

        // WHEN
        val actual = repository.getUserStories().first()

        // THEN
        assertEquals(userStories, actual)
    }

    @Test
    fun `get user story, should return user story`() = runTest {
        // GIVEN
        val userStories =
            List(5) {
                DomainFixtures.randomUserStory()
            }.onEach { repository.createUserStory(it) }

        val userStory = userStories.random()

        // WHEN
        val actual = repository.getUserStory(userStory.id)

        // THEN
        assertEquals(userStory, actual.first())
    }

    @Test
    fun `create user story, should save user story`() = runTest {
        // GIVEN
        val userStory = DomainFixtures.randomUserStory()

        // WHEN
        repository.createUserStory(userStory)

        // THEN
        assertEquals(userStory, repository.getUserStory(userStory.id).first())
    }
}
