package com.github.mcgalanes.groomr.core.data.fixture

import com.github.mcgalanes.groomr.core.domain.model.UserStory
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

fun Random.nextUserStory(
    criteriaList: List<UserStory.Criteria> = listOf(
        Random.nextCriteria(),
        Random.nextCriteria(),
        Random.nextCriteria(),
    ),
): UserStory =
    UserStory(
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
        criteriaList = criteriaList,
    )

fun Random.nextCriteria(): UserStory.Criteria =
    UserStory.Criteria(
        title = "Title ${nextInt(1..100)}",
        gherkinLines = listOf(
            Random.nextGherkinLine(),
            Random.nextGherkinLine(),
            Random.nextGherkinLine(),
        ),
    )

fun Random.nextGherkinLine(): UserStory.Criteria.GherkinLine =
    UserStory.Criteria.GherkinLine(
        key = UserStory.Criteria.GherkinLine.GherkinKey.entries.toTypedArray().random(),
        value = "Value ${nextInt(1..100)}",
    )
