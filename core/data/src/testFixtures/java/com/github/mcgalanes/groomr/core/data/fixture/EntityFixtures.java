package com.github.mcgalanes.groomr.core.data.fixture;

import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity;
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity;
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity.GherkinKey;
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity;

import kotlin.random.Random;


public class EntityFixtures {

    private static final Random random = Random.Default;

    public static UserStoryEntity randomUserStoryEntity() {
        return new UserStoryEntity(
            random.nextLong(1, Long.MAX_VALUE),
            "User Story " + random.nextInt(1, 100),
            "Persona " + random.nextInt(1, 100),
            "Wish " + random.nextInt(1, 100),
            "Purpose " + random.nextInt(1, 100),
            "KPI " + random.nextInt(1, 100),
            random.nextInt(1, 100),
            "Solution " + random.nextInt(1, 100),
            "Enablers " + random.nextInt(1, 100),
            "Assets " + random.nextInt(1, 100),
            random.nextInt(1, 100),
            random.nextBoolean(),
            random.nextBoolean(),
            random.nextBoolean(),
            random.nextBoolean()
        );
    }

    public static GherkinLineEntity randomGherkinLineEntity() {
        GherkinKey[] keys = GherkinKey.getEntries().toArray(GherkinKey[]::new);
        return new GherkinLineEntity(
            random.nextLong(1, Long.MAX_VALUE),
            keys[random.nextInt(keys.length)],
            "Value " + random.nextInt(1, 100),
            random.nextLong(1, Long.MAX_VALUE)
        );
    }

    public static CriteriaEntity randomCriteriaEntity() {
        return new CriteriaEntity(
            random.nextLong(1, Long.MAX_VALUE),
            random.nextLong(1, Long.MAX_VALUE),
            "Title " + random.nextInt(1, 100)
        );
    }
}
