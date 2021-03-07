package ru.nick252.types

data class EventData(
    val entityId: String? = null,
    val oldState: State? = null,
    val newState: State? = null
)