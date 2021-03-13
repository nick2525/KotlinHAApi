package ru.nick252.types.results.services

data class ServicesNameTarget(
    val name: String?,
    val description: String?,
    val fields: ServicesFields?,
    val target: ServicesTarget?
)