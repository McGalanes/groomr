package com.github.mcgalanes.groomr.core.data

import com.github.mcgalanes.groomr.core.data.fake.FakeUserStoryDao
import com.github.mcgalanes.groomr.core.data.fixture.nextCriteriaEntity
import com.github.mcgalanes.groomr.core.data.fixture.nextGherkinLineEntity
import com.github.mcgalanes.groomr.core.data.fixture.nextUserStoryEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriteriaList
import com.github.mcgalanes.groomr.core.data.local.entity.toDomain
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class DefaultUserStoryRepositoryTest {

    @Test
    fun `get user story, should return user story`() = runTest {
        // GIVEN
        val userStory = Random.nextUserStoryEntity()
        val criteria = Random.nextCriteriaEntity()

        val userStoryWithCriteriaList =
            UserStoryWithCriteriaList(
                userStory = userStory,
                criteriaList = listOf(criteria),
            )

        val gherkinLines =
            listOf(
                Random.nextGherkinLineEntity(criteriaId = criteria.id),
                Random.nextGherkinLineEntity(criteriaId = criteria.id),
                Random.nextGherkinLineEntity(criteriaId = criteria.id),
            )

        val dao = FakeUserStoryDao(
            mockGetUserStoryWithCriteriaList = { flowOf(userStoryWithCriteriaList) },
            mockGetGherkinLinesByCriteriaId = { gherkinLines },
        )

        val repository = DefaultUserStoryRepository(dao)

        // WHEN
        val actual = repository.getUserStory(userStory.id)

        // THEN
        Assert.assertEquals(
            userStory.toDomain(
                criteriaList = userStoryWithCriteriaList.criteriaList
                    .map {
                        it.toDomain(gherkinLines = gherkinLines.map(GherkinLineEntity::toDomain))
                    },
            ),
            actual.first(),
        )
    }
}
