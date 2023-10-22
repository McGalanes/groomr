package com.github.mcgalanes.groomr.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.mcgalanes.groomr.core.domain.model.UserStory

private const val TABLE_NAME = "gherkin_line"

@Entity(tableName = TABLE_NAME)
data class GherkinLineEntity(
    @ColumnInfo(COLUMN_NAME_ID) @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(COLUMN_NAME_GHERKIN_KEY) val gherkinKey: GherkinKey,
    @ColumnInfo(COLUMN_NAME_VALUE) val value: String,
    @ColumnInfo(COLUMN_NAME_CRITERIA_ID) val criteriaId: Long,
) {
    enum class GherkinKey {
        Given,
        When,
        Then,
        And,
    }

    companion object {
        internal const val COLUMN_NAME_CRITERIA_ID = "criteria_id"
        private const val COLUMN_NAME_ID = "id"
        private const val COLUMN_NAME_GHERKIN_KEY = "gherkin_key"
        private const val COLUMN_NAME_VALUE = "value"
    }
}

fun GherkinLineEntity.toDomain(): UserStory.Criteria.GherkinLine {
    return UserStory.Criteria.GherkinLine(
        key = gherkinKey.toDomain(),
        value = value,
    )
}

fun GherkinLineEntity.GherkinKey.toDomain(): UserStory.Criteria.GherkinLine.GherkinKey =
    when (this) {
        GherkinLineEntity.GherkinKey.Given -> UserStory.Criteria.GherkinLine.GherkinKey.Given
        GherkinLineEntity.GherkinKey.When -> UserStory.Criteria.GherkinLine.GherkinKey.When
        GherkinLineEntity.GherkinKey.Then -> UserStory.Criteria.GherkinLine.GherkinKey.Then
        GherkinLineEntity.GherkinKey.And -> UserStory.Criteria.GherkinLine.GherkinKey.And
    }
