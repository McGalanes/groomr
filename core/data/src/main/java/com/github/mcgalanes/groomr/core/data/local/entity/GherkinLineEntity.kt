package com.github.mcgalanes.groomr.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "gherkin_line"

@Entity(tableName = TABLE_NAME)
data class GherkinLineEntity(
    @ColumnInfo(COLUMN_NAME_ID) @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(COLUMN_NAME_GHERKIN_KEY) val gherkinKey: GherkinKey,
    @ColumnInfo(COLUMN_NAME_VALUE) val value: String,
    @ColumnInfo(COLUMN_NAME_CRITERIA_ID) val criteriaId: String,
) {
    enum class GherkinKey {
        GIVEN,
        WHEN,
        THEN,
        AND,
    }

    companion object {
        internal const val COLUMN_NAME_CRITERIA_ID = "criteria_id"
        private const val COLUMN_NAME_ID = "id"
        private const val COLUMN_NAME_GHERKIN_KEY = "gherkin_key"
        private const val COLUMN_NAME_VALUE = "value"
    }
}

