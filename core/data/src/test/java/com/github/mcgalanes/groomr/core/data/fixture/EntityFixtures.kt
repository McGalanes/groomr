package com.github.mcgalanes.groomr.core.data.fixture

import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

fun Random.nextUserStoryEntity(): UserStoryEntity =
    UserStoryEntity(
        id = nextLong(1..Long.MAX_VALUE),
        title = "User Story ${nextInt(1..100)}",
        persona = "Persona ${nextInt(1..100)}",
        wish = "Wish ${nextInt(1..100)}",
        purpose = "Purpose ${nextInt(1..100)}",
        kpi = "KPI ${nextInt(1..100)}",
        businessValue = nextInt(1..100),
        solution = "Solution ${nextInt(1..100)}",
        enablers = "Enablers ${nextInt(1..100)}",
        assets = "Assets ${nextInt(1..100)}",
        estimation = nextInt(1..100),
        smallEnough = nextBoolean(),
        independent = nextBoolean(),
        estimable = nextBoolean(),
        testable = nextBoolean(),
    )

fun Random.nextGherkinLineEntity(
    criteriaId: Long = nextLong(1..Long.MAX_VALUE),
): GherkinLineEntity =
    GherkinLineEntity(
        id = nextLong(1..Long.MAX_VALUE),
        gherkinKey = GherkinLineEntity.GherkinKey.entries.toTypedArray().random(),
        value = "Value ${nextInt(1..100)}",
        criteriaId = criteriaId,
    )

fun Random.nextCriteriaEntity(): CriteriaEntity =
    CriteriaEntity(
        id = nextLong(1..Long.MAX_VALUE),
        userStoryId = nextLong(1..Long.MAX_VALUE),
        title = "Title ${nextInt(1..100)}",
    )
