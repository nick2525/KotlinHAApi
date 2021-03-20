package ru.nick252.types.results.services

data class ServicesLogger(
    val setDefaultLevel: ServicesNameDescriptionFields?,
    val setLevel: ServicesDescriptionExample?,
    val name: String?,
    val description: String?,
    val example: String?,
    val selector: ServicesSelector?
)