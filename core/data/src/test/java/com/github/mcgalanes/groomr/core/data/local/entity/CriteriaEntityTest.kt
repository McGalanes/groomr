package com.github.mcgalanes.groomr.core.data.local.entity

import com.github.mcgalanes.groomr.core.data.fixture.nextCriteria
import com.github.mcgalanes.groomr.core.data.fixture.nextCriteriaEntity
import com.github.mcgalanes.groomr.core.data.fixture.nextGherkinLine
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class CriteriaEntityTest {

    @Test
    fun `should map criteria to domain`() {
        // GIVEN
        val criteriaEntity = Random.nextCriteriaEntity()

        val gherkinLines = listOf(
            Random.nextGherkinLine(),
            Random.nextGherkinLine(),
        )

        // WHEN
        val actual = criteriaEntity.toDomain(gherkinLines)

        // THEN
        Assert.assertEquals(
            UserStory.Criteria(
                id = criteriaEntity.id,
                title = criteriaEntity.title,
                gherkinLines = gherkinLines,
            ),
            actual,
        )
    }

    @Test
    fun `should map criteria to entity`() {
        // GIVEN
        val criteria = Random.nextCriteria()

        // WHEN
        val actual = criteria.toEntity(userStoryId = 1)

        // THEN
        Assert.assertEquals(
            CriteriaEntity(
                id = criteria.id,
                title = criteria.title,
                userStoryId = 1,
            ),
            actual,
        )
    }
}
