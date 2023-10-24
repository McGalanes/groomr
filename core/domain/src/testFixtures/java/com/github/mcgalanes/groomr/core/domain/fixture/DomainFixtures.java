package com.github.mcgalanes.groomr.core.domain.fixture;

import com.github.mcgalanes.groomr.core.domain.model.UserStory;
import com.github.mcgalanes.groomr.core.domain.model.UserStory.Criteria;
import com.github.mcgalanes.groomr.core.domain.model.UserStory.Criteria.GherkinLine;
import com.github.mcgalanes.groomr.core.domain.model.UserStory.Criteria.GherkinLine.GherkinKey;

import java.util.ArrayList;
import java.util.List;

import kotlin.random.Random;


public class DomainFixtures {
    private static final Random random = Random.Default;

    public static UserStory randomUserStory() {
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(randomCriteria());
        criteriaList.add(randomCriteria());
        criteriaList.add(randomCriteria());

        return new UserStory(
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
            random.nextBoolean(),
            criteriaList
        );
    }

    public static Criteria randomCriteria() {
        List<GherkinLine> gherkinLines = new ArrayList<>();
        gherkinLines.add(randomGherkinLine());
        gherkinLines.add(randomGherkinLine());
        gherkinLines.add(randomGherkinLine());

        return new Criteria(
            random.nextLong(1, Long.MAX_VALUE),
            "Title " + random.nextInt(1, 100),
            gherkinLines
        );
    }

    public static GherkinLine randomGherkinLine() {
        Random random = Random.Default;

        GherkinKey[] keys = GherkinKey
            .getEntries()
            .toArray(GherkinKey[]::new);

        return new GherkinLine(
            random.nextLong(1, Long.MAX_VALUE),
            keys[random.nextInt(keys.length)],
            "Value " + random.nextInt(1, 100)
        );
    }
}
