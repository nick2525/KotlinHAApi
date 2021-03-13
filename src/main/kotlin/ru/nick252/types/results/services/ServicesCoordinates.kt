package ru.nick252.types.results.services

data class ServicesCoordinates(
    val name: String?,
    val description: String?,
    val required: Boolean?,
    val example: Double?,
    val selector: ServicesSelector?
)