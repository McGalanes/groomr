package com.github.mcgalanes.groomr.core.data.local.entity

import com.github.mcgalanes.groomr.core.data.fixture.nextGherkinLine
import com.github.mcgalanes.groomr.core.data.fixture.nextGherkinLineEntity
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

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
        val gherkinLineEntity = Random.nextGherkinLineEntity()

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

    @Test
    fun `should map gherkin line to entity`() {
        // GIVEN
        val gherkinLine = Random.nextGherkinLine()
        val criteriaId = 1L

        // WHEN
        val actual = gherkinLine.toEntity(criteriaId)

        // THEN
        Assert.assertEquals(
            GherkinLineEntity(
                gherkinKey = gherkinLine.key.toEntity(),
                value = gherkinLine.value,
                criteriaId = criteriaId,
            ),
            actual,
        )
    }

    @Test
    fun `should map gherkin key to entity`() {
        // GIVEN
        UserStory.Criteria.GherkinLine.GherkinKey.entries.forEach { gherkinKey ->
            // WHEN
            val actual = gherkinKey.toEntity()

            // THEN
            Assert.assertEquals(
                when (gherkinKey) {
                    UserStory.Criteria.GherkinLine.GherkinKey.Given -> GherkinLineEntity.GherkinKey.Given
                    UserStory.Criteria.GherkinLine.GherkinKey.When -> GherkinLineEntity.GherkinKey.When
                    UserStory.Criteria.GherkinLine.GherkinKey.Then -> GherkinLineEntity.GherkinKey.Then
                    UserStory.Criteria.GherkinLine.GherkinKey.And -> GherkinLineEntity.GherkinKey.And
                },
                actual,
            )
        }
    }
}
