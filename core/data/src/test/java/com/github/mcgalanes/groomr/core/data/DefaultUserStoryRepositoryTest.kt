package com.github.mcgalanes.groomr.core.data

import com.github.mcgalanes.groomr.core.data.fake.FakeUserStoryDao
import com.github.mcgalanes.groomr.core.data.fixture.EntityFixtures
import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriterias
import com.github.mcgalanes.groomr.core.data.local.entity.toDomain
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
        val userStoryEntity = EntityFixtures.randomUserStoryEntity()
        val criteriaEntity = EntityFixtures.randomCriteriaEntity()
        val gherkinLineEntityList =
            listOf(
                EntityFixtures.randomGherkinLineEntity(),
                EntityFixtures.randomGherkinLineEntity(),
                EntityFixtures.randomGherkinLineEntity(),
            )

        val userStoryWithCriterias =
            UserStoryWithCriterias(
                userStory = userStoryEntity,
                criterias = listOf(criteriaEntity),
            )

        val userStoryId = dao.createUserStory(userStoryEntity)
        val criteriaId = dao.createCriteria(criteriaEntity.copy(userStoryId = userStoryId))
        gherkinLineEntityList.map { dao.createGherkinLine(it.copy(criteriaId = criteriaId)) }

        // WHEN
        val actual = repository.getUserStory(userStoryId)

        // THEN
        val expected =
            userStoryEntity
                .toDomain(
                    criterias = userStoryWithCriterias.criterias.map { criteria ->
                        criteria.toDomain(
                            gherkinLines = gherkinLineEntityList.map { gherkinLine ->
                                gherkinLine.toDomain()
                            },
                        )
                    },
                )

        assertEquals(expected, actual.first())
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
