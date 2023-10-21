package com.github.mcgalanes.groomr.core.domain.model

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
