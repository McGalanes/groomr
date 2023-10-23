package com.github.mcgalanes.groomr.core.data.local.entity

import com.github.mcgalanes.groomr.core.data.fixture.nextCriteriaEntity
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.model.UserStory.Criteria.GherkinLine.GherkinKey
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class CriteriaEntityTest {

    @Test
    fun `should map criteria to domain`() {
        // GIVEN
        val criteriaEntity = Random.nextCriteriaEntity()

        val gherkinLines = listOf(
            UserStory.Criteria.GherkinLine(
                key = GherkinKey.Given,
                value = "foo",
            ),
            UserStory.Criteria.GherkinLine(
                key = GherkinKey.When,
                value = "faa",
            ),
        )

        // WHEN
        val actual = criteriaEntity.toDomain(gherkinLines)

        // THEN
        Assert.assertEquals(
            UserStory.Criteria(
                title = criteriaEntity.title,
                gherkinLines = gherkinLines,
            ),
            actual,
        )
    }
}
