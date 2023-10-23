package com.github.mcgalanes.groomr.core.data

import com.github.mcgalanes.groomr.core.data.fake.FakeUserStoryDao
import com.github.mcgalanes.groomr.core.data.fixture.nextCriteriaEntity
import com.github.mcgalanes.groomr.core.data.fixture.nextGherkinLineEntity
import com.github.mcgalanes.groomr.core.data.fixture.nextUserStory
import com.github.mcgalanes.groomr.core.data.fixture.nextUserStoryEntity
import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriteriaList
import com.github.mcgalanes.groomr.core.data.local.entity.toDomain
import com.github.mcgalanes.groomr.core.domain.UserStoryRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class DefaultUserStoryRepositoryTest {

    private lateinit var dao: UserStoryDao
    private lateinit var repository: UserStoryRepository

    @Before
    fun setUp() {
        dao = FakeUserStoryDao()
        repository = DefaultUserStoryRepository(dao)
    }

    @Test
    fun `get user story, should return user story`() = runTest {
        // GIVEN
        val userStoryEntity = Random.nextUserStoryEntity()
        val criteriaEntity = Random.nextCriteriaEntity()
        val gherkinLineEntityList =
            listOf(
                Random.nextGherkinLineEntity(),
                Random.nextGherkinLineEntity(),
                Random.nextGherkinLineEntity(),
            )

        val userStoryWithCriteriaList =
            UserStoryWithCriteriaList(
                userStory = userStoryEntity,
                criteriaList = listOf(criteriaEntity),
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
                    criteriaList = userStoryWithCriteriaList.criteriaList.map { criteria ->
                        criteria.toDomain(
                            gherkinLines = gherkinLineEntityList.map { gherkinLine ->
                                gherkinLine.toDomain()
                            },
                        )
                    },
                )

        Assert.assertEquals(expected, actual.first())
    }

    @Test
    fun `save user story, should save user story`() = runTest {
        // GIVEN
        val userStory = Random.nextUserStory()

        // WHEN
        repository.createUserStory(userStory)

        // THEN
        Assert.assertEquals(userStory, repository.getUserStory(userStory.id).first())
    }
}
