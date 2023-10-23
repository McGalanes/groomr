package com.github.mcgalanes.groomr.core.data.fake

import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriteriaList
import kotlinx.coroutines.flow.Flow

class FakeUserStoryDao(
    private val mockGetUserStoryWithCriteriaList: (Long) -> Flow<UserStoryWithCriteriaList> = { TODO() },
    private val mockGetGherkinLinesByCriteriaId: (Long) -> List<GherkinLineEntity> = { TODO() },
) : UserStoryDao {
    override fun getUserStoryWithCriteriaList(id: Long): Flow<UserStoryWithCriteriaList> =
        mockGetUserStoryWithCriteriaList(id)

    override suspend fun getGherkinLinesByCriteriaId(id: Long): List<GherkinLineEntity> =
        mockGetGherkinLinesByCriteriaId(id)

    override suspend fun createUserStory(userStory: UserStoryEntity): Long {
        TODO("not implemented")
    }

    override suspend fun createCriteria(criteria: CriteriaEntity): Long {
        TODO("not implemented")
    }

    override suspend fun createGherkinLine(gherkinLine: GherkinLineEntity): Long {
        TODO("not implemented")
    }
}
