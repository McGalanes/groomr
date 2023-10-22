package com.github.mcgalanes.groomr.core.data.local.entity

import com.github.mcgalanes.groomr.core.domain.model.UserStory
import org.junit.Assert
import org.junit.Test

class GherkinLineEntityTest {

    @Test
    fun `should map gherkin key to domain`() {
        // GIVEN
        GherkinLineEntity.GherkinKey.entries.forEach { gherkinKey ->
            // WHEN
            val actual = gherkinKey.toDomain()

            // THEN
            Assert.assertEquals(
                when (gherkinKey) {
                    GherkinLineEntity.GherkinKey.Given -> UserStory.Criteria.GherkinLine.GherkinKey.Given
                    GherkinLineEntity.GherkinKey.When -> UserStory.Criteria.GherkinLine.GherkinKey.When
                    GherkinLineEntity.GherkinKey.Then -> UserStory.Criteria.GherkinLine.GherkinKey.Then
                    GherkinLineEntity.GherkinKey.And -> UserStory.Criteria.GherkinLine.GherkinKey.And
                },
                actual,
            )
        }
    }

    @Test
    fun `should map gherkin line to domain`() {
        // GIVEN
        val gherkinLineEntity = GherkinLineEntity(
            id = 1L,
            criteriaId = 1L,
            gherkinKey = GherkinLineEntity.GherkinKey.Given,
            value = "value",
        )

        // WHEN
        val actual = gherkinLineEntity.toDomain()

        // THEN
        Assert.assertEquals(
            UserStory.Criteria.GherkinLine(
                key = gherkinLineEntity.gherkinKey.toDomain(),
                value = gherkinLineEntity.value,
            ),
            actual,
        )
    }
}
