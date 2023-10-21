package com.github.mcgalanes.groomr.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity
import com.github.mcgalanes.groomr.core.data.local.entity.relation.CriteriaWithGherkinLineList
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriteriaList

@Dao
interface UserStoryDao {
    @Transaction
    @Query("SELECT * FROM `user_story` WHERE id = :id")
    suspend fun getUserStoryWithCriteriaList(id: Long): UserStoryWithCriteriaList

    @Transaction
    @Query("SELECT * FROM `criteria` WHERE id = :id")
    suspend fun getCriteriaWithGherkinLineList(id: Long): CriteriaWithGherkinLineList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUserStory(userStory: UserStoryEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCriteria(criteria: CriteriaEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createGherkinLine(gherkinLine: GherkinLineEntity): Long
}
