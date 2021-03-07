package ru.nick252.types

data class EventMessage(
    val eventType: String? = null,
    val data: EventData? = null,
    val origin: String? = null,
    val timeFired: String? = null,
    val context: Context? = null
)