package com.github.mcgalanes.groomr.core.data.fake

import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriterias
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

internal class FakeUserStoryDao : UserStoryDao {
    private val userStoriesFlow = MutableStateFlow(emptyList<UserStoryEntity>())
    private val criteriasFlow = MutableStateFlow(emptyList<CriteriaEntity>())
    private val gherkinLinesFlow = MutableStateFlow(emptyList<GherkinLineEntity>())


    override fun getUserStoriesWithCriterias(): Flow<List<UserStoryWithCriterias>> =
        userStoriesFlow
            .map { entities ->
                entities.map { getUserStoryWithCriterias(it.id).first() }
            }


    override fun getUserStoryWithCriterias(id: Long): Flow<UserStoryWithCriterias> =
        userStoriesFlow
            .map { userStories -> userStories.first { it.id == id } }
            .map { userStory ->
                UserStoryWithCriterias(
                    userStory = userStory,
                    criterias = criteriasFlow.value.filter { it.userStoryId == id },
                )
            }

    override suspend fun getGherkinLinesByCriteriaId(id: Long): List<GherkinLineEntity> =
        gherkinLinesFlow.value.filter { it.criteriaId == id }

    override suspend fun createUserStory(userStory: UserStoryEntity): Long {
        userStoriesFlow.update { it + userStory }
        return userStory.id
    }

    override suspend fun createCriteria(criteria: CriteriaEntity): Long {
        criteriasFlow.update { (it + criteria) }
        return criteria.id
    }

    override suspend fun createGherkinLine(gherkinLine: GherkinLineEntity): Long {
        gherkinLinesFlow.update { it + gherkinLine }
        return gherkinLine.id
    }
}
