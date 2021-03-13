package ru.nick252.types.results.states

import ru.nick252.types.Context

data class StatesResult(
    val context: Context?,
    val state: String? = null,
    val entityId: String?,
    val attributes: StatesAttributes?,
    val lastChanged: String?,
    val lastUpdated: String?
)