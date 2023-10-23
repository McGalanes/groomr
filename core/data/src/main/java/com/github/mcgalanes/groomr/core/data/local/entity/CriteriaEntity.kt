package com.github.mcgalanes.groomr.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.mcgalanes.groomr.core.domain.model.UserStory

private const val TABLE_NAME = "criteria"

@Entity(tableName = TABLE_NAME)
data class CriteriaEntity(
    @ColumnInfo(COLUMN_NAME_ID) @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(COLUMN_NAME_USER_STORY_ID) val userStoryId: Long,
    @ColumnInfo(COLUMN_NAME_TITLE) val title: String,
) {
    companion object {
        internal const val COLUMN_NAME_ID = "id"
        internal const val COLUMN_NAME_USER_STORY_ID = "user_story_id"
        private const val COLUMN_NAME_TITLE = "title"
    }
}

fun CriteriaEntity.toDomain(
    gherkinLines: List<UserStory.Criteria.GherkinLine>,
): UserStory.Criteria =
    UserStory.Criteria(
        title = title,
        gherkinLines = gherkinLines,
    )

fun UserStory.Criteria.toEntity(userStoryId: Long): CriteriaEntity =
    CriteriaEntity(
        title = title,
        userStoryId = userStoryId,
    )
