package com.github.mcgalanes.groomr.core.data.local.entity

import com.github.mcgalanes.groomr.core.data.fixture.EntityFixtures
import com.github.mcgalanes.groomr.core.domain.fixture.DomainFixtures
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import org.junit.Assert
import org.junit.Test

class CriteriaEntityTest {

    @Test
    fun `should map criteria to domain`() {
        // GIVEN
        val criteriaEntity = EntityFixtures.randomCriteriaEntity()

        val gherkinLines = listOf(
            DomainFixtures.randomGherkinLine(),
            DomainFixtures.randomGherkinLine(),
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
        val criteria = DomainFixtures.randomCriteria()

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
