package ru.nick252.types

class State(
    val entityId: String? = null,
    val state: String? = null,
    val attributes: Attributes? = null,
    val lastChanged: String? = null,
    val lastUpdated: String? = null,
    val context: Context? = null
)