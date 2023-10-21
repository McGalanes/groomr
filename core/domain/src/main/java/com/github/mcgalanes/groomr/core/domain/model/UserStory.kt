package com.github.mcgalanes.groomr.core.domain.model

data class UserStory(
    val id: Long,
    val title: String,
    val persona: String,
    val wish: String,
    val purpose: String,
    val kpi: String,
    val businessValue: Int,
    val solution: String,
    val enablers: String,
    val assets: String,
    val estimation: Int,
    val smallEnough: Boolean,
    val independent: Boolean,
    val estimable: Boolean,
    val testable: Boolean,
    val criteriaList: List<Criteria>,
) {
    data class Criteria(
        val title: String,
        val gherkinLines: List<GherkinLine>,
    ) {
        data class GherkinLine(
            val key: GherkinKey,
            val value: String,
        ) {
            enum class GherkinKey {
                Given,
                When,
                Then,
                And,
            }
        }
    }
}
