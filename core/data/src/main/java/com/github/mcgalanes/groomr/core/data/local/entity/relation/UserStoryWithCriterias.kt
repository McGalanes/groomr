package com.github.mcgalanes.groomr.core.data.local.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity

data class UserStoryWithCriterias(
    @Embedded val userStory: UserStoryEntity,
    @Relation(
        parentColumn = UserStoryEntity.COLUMN_NAME_ID,
        entityColumn = CriteriaEntity.COLUMN_NAME_USER_STORY_ID,
    )
    val criterias: List<CriteriaEntity>,
)
