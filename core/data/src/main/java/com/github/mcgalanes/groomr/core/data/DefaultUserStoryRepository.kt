package com.github.mcgalanes.groomr.core.data

import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.toDomain
import com.github.mcgalanes.groomr.core.data.local.entity.toEntity
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import com.github.mcgalanes.groomr.core.domain.model.UserStory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultUserStoryRepository
@Inject constructor(
    private val dao: UserStoryDao,
) : UserStoryRepository {

    override fun getUserStory(id: Long): Flow<UserStory> {
        return dao.getUserStoryWithCriteriaList(id)
            .map { it.userStory to it.criteriaList }
            .map { (userStory, criteriaList) ->
                userStory.toDomain(
                    criteriaList = criteriaList.map { criteria ->
                        criteria.toDomain(
                            gherkinLines = dao.getGherkinLinesByCriteriaId(criteria.id)
                                .map(GherkinLineEntity::toDomain),
                        )
                    },
                )
            }
    }

    override suspend fun createUserStory(userStory: UserStory) {
        val userStoryId = dao.createUserStory(userStory.toEntity())

        userStory.criteriaList.forEach { criteria ->
            val criteriaId = dao.createCriteria(criteria.toEntity(userStoryId = userStoryId))

            criteria.gherkinLines.forEach { gherkinLine ->
                dao.createGherkinLine(gherkinLine.toEntity(criteriaId = criteriaId))
            }
        }
    }
}
