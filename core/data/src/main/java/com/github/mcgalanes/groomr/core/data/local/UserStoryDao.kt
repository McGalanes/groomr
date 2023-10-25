package com.github.mcgalanes.groomr.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriterias
import kotlinx.coroutines.flow.Flow

@Dao
interface UserStoryDao {
    @Transaction
    @Query("SELECT * FROM `user_story`")
    fun getUserStoriesWithCriterias(): Flow<List<UserStoryWithCriterias>>

    @Transaction
    @Query("SELECT * FROM `user_story` WHERE id = :id")
    fun getUserStoryWithCriterias(id: Long): Flow<UserStoryWithCriterias>

    @Query("SELECT * FROM `gherkin_line` WHERE criteria_id = :id")
    suspend fun getGherkinLinesByCriteriaId(id: Long): List<GherkinLineEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUserStory(userStory: UserStoryEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCriteria(criteria: CriteriaEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createGherkinLine(gherkinLine: GherkinLineEntity): Long
}
