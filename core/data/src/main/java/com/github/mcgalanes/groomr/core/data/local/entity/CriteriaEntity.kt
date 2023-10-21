package com.github.mcgalanes.groomr.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "criteria"

@Entity(tableName = TABLE_NAME)
data class CriteriaEntity(
    @ColumnInfo(COLUMN_NAME_ID) @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(COLUMN_NAME_USER_STORY_ID) val userStoryId: String,
    @ColumnInfo(COLUMN_NAME_TITLE) val title: String,
) {
    companion object {
        internal const val COLUMN_NAME_ID = "id"
        internal const val COLUMN_NAME_USER_STORY_ID = "user_story_id"
        private const val COLUMN_NAME_TITLE = "title"
    }
}
