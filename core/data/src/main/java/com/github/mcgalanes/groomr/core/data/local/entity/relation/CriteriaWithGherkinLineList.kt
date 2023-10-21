package com.github.mcgalanes.groomr.core.data.local.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity

data class CriteriaWithGherkinLineList(
    @Embedded val criteria: CriteriaEntity,
    @Relation(
        parentColumn = CriteriaEntity.COLUMN_NAME_ID,
        entityColumn = GherkinLineEntity.COLUMN_NAME_CRITERIA_ID,
    )
    val gherkinLineList: List<GherkinLineEntity>,
)
