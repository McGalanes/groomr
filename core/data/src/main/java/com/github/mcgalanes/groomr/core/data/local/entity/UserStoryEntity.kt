package com.github.mcgalanes.groomr.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.mcgalanes.groomr.core.domain.model.UserStory

private const val TABLE_NAME = "user_story"

@Entity(tableName = TABLE_NAME)
data class UserStoryEntity(
    @ColumnInfo(COLUMN_NAME_ID) @PrimaryKey(autoGenerate = true) val id: Long = -1,
    @ColumnInfo(COLUMN_NAME_TITLE) val title: String,
    @ColumnInfo(COLUMN_NAME_PERSONA) val persona: String,
    @ColumnInfo(COLUMN_NAME_WISH) val wish: String,
    @ColumnInfo(COLUMN_NAME_PURPOSE) val purpose: String,
    @ColumnInfo(COLUMN_NAME_KPI) val kpi: String,
    @ColumnInfo(COLUMN_NAME_BUSINESS_VALUE) val businessValue: Int,
    @ColumnInfo(COLUMN_NAME_SOLUTION) val solution: String,
    @ColumnInfo(COLUMN_NAME_ENABLERS) val enablers: String,
    @ColumnInfo(COLUMN_NAME_ASSETS) val assets: String,
    @ColumnInfo(COLUMN_NAME_ESTIMATION) val estimation: Int,
    @ColumnInfo(COLUMN_NAME_SMALL_ENOUGH) val smallEnough: Boolean,
    @ColumnInfo(COLUMN_NAME_INDEPENDENT) val independent: Boolean,
    @ColumnInfo(COLUMN_NAME_ESTIMABLE) val estimable: Boolean,
    @ColumnInfo(COLUMN_NAME_TESTABLE) val testable: Boolean,
) {
    companion object {
        internal const val COLUMN_NAME_ID = "id"
        private const val COLUMN_NAME_TITLE = "title"
        private const val COLUMN_NAME_PERSONA = "persona"
        private const val COLUMN_NAME_WISH = "wish"
        private const val COLUMN_NAME_PURPOSE = "purpose"
        private const val COLUMN_NAME_KPI = "kpi"
        private const val COLUMN_NAME_BUSINESS_VALUE = "business_value"
        private const val COLUMN_NAME_SOLUTION = "solution"
        private const val COLUMN_NAME_ENABLERS = "enablers"
        private const val COLUMN_NAME_ASSETS = "assets"
        private const val COLUMN_NAME_ESTIMATION = "estimation"
        private const val COLUMN_NAME_SMALL_ENOUGH = "small_enough"
        private const val COLUMN_NAME_INDEPENDENT = "independent"
        private const val COLUMN_NAME_ESTIMABLE = "estimable"
        private const val COLUMN_NAME_TESTABLE = "testable"
    }
}

fun UserStoryEntity.toDomain(criteriaList: List<UserStory.Criteria>): UserStory =
    UserStory(
        id = id,
        title = title,
        persona = persona,
        wish = wish,
        purpose = purpose,
        kpi = kpi,
        businessValue = businessValue,
        solution = solution,
        enablers = enablers,
        assets = assets,
        estimation = estimation,
        smallEnough = smallEnough,
        independent = independent,
        estimable = estimable,
        testable = testable,
        criteriaList = criteriaList,
    )

fun UserStory.toEntity(): UserStoryEntity =
    UserStoryEntity(
        id = id,
        title = title,
        persona = persona,
        wish = wish,
        purpose = purpose,
        kpi = kpi,
        businessValue = businessValue,
        solution = solution,
        enablers = enablers,
        assets = assets,
        estimation = estimation,
        smallEnough = smallEnough,
        independent = independent,
        estimable = estimable,
        testable = testable,
    )
