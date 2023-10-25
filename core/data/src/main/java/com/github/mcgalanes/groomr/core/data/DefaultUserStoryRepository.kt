package com.github.mcgalanes.groomr.core.data

import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.relation.UserStoryWithCriterias
import com.github.mcgalanes.groomr.core.data.local.entity.toDomain
import com.github.mcgalanes.groomr.core.data.local.entity.toEntity
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultUserStoryRepository
@Inject constructor(
    private val dao: UserStoryDao,
) : UserStoryRepository {

    override fun getUserStories(): Flow<List<UserStory>> =
        dao.getUserStoriesWithCriterias()
            .map { entities ->
                entities.map { it.toDomain() }
            }

    override fun getUserStory(id: Long): Flow<UserStory> =
        dao.getUserStoryWithCriterias(id).map { it.toDomain() }

    override suspend fun createUserStory(userStory: UserStory) {
        val userStoryId = dao.createUserStory(userStory.toEntity())

        userStory.criterias.forEach { criteria ->
            val criteriaId = dao.createCriteria(criteria.toEntity(userStoryId = userStoryId))

            criteria.gherkinLines.forEach { gherkinLine ->
                dao.createGherkinLine(gherkinLine.toEntity(criteriaId = criteriaId))
            }
        }
    }

    private suspend fun UserStoryWithCriterias.toDomain(): UserStory =
        userStory.toDomain(
            criterias = criterias.map { criteria ->
                criteria.toDomain(
                    gherkinLines = dao.getGherkinLinesByCriteriaId(criteria.id)
                        .map(GherkinLineEntity::toDomain),
                )
            },
        )
}
