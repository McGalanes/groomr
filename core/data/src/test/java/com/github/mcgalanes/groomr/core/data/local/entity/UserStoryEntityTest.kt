package com.github.mcgalanes.groomr.core.data.local.entity

import com.github.mcgalanes.groomr.core.data.fixture.nextUserStory
import com.github.mcgalanes.groomr.core.data.fixture.nextUserStoryEntity
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.model.UserStory.Criteria.GherkinLine.GherkinKey
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.random.Random

class UserStoryEntityTest {

    @Test
    fun `should map user story to domain`() {
        // GIVEN
        val userStoryEntity = Random.nextUserStoryEntity()

        val criteriaList = listOf(
            UserStory.Criteria(
                title = "title",
                gherkinLines = listOf(
                    UserStory.Criteria.GherkinLine(
                        key = GherkinKey.Given,
                        value = "foo",
                    ),
                    UserStory.Criteria.GherkinLine(
                        key = GherkinKey.When,
                        value = "faa",
                    ),
                ),
            ),
        )

        // WHEN
        val actual = userStoryEntity.toDomain(criteriaList)

        // THEN
        assertEquals(
            UserStory(
                id = userStoryEntity.id,
                title = userStoryEntity.title,
                persona = userStoryEntity.persona,
                wish = userStoryEntity.wish,
                purpose = userStoryEntity.purpose,
                kpi = userStoryEntity.kpi,
                businessValue = userStoryEntity.businessValue,
                solution = userStoryEntity.solution,
                enablers = userStoryEntity.enablers,
                assets = userStoryEntity.assets,
                estimation = userStoryEntity.estimation,
                smallEnough = userStoryEntity.smallEnough,
                independent = userStoryEntity.independent,
                estimable = userStoryEntity.estimable,
                testable = userStoryEntity.testable,
                criteriaList = criteriaList,
            ),
            actual,
        )
    }

    @Test
    fun `should map user story to entity`() {
        // GIVEN
        val userStory = Random.nextUserStory()

        // WHEN
        val actual = userStory.toEntity()

        // THEN
        assertEquals(
            UserStoryEntity(
                id = userStory.id,
                title = userStory.title,
                persona = userStory.persona,
                wish = userStory.wish,
                purpose = userStory.purpose,
                kpi = userStory.kpi,
                businessValue = userStory.businessValue,
                solution = userStory.solution,
                enablers = userStory.enablers,
                assets = userStory.assets,
                estimation = userStory.estimation,
                smallEnough = userStory.smallEnough,
                independent = userStory.independent,
                estimable = userStory.estimable,
                testable = userStory.testable,
            ),
            actual,
        )
    }
}
