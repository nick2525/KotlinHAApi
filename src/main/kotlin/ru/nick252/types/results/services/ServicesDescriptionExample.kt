package ru.nick252.types.results.services

data class ServicesDescriptionExample(
    val description: String?,
    val example: String?,
    val name: String?,
    val default: Boolean?,
    val selector: ServicesSelector?,
    val fields: ServicesFields?,
    val required: String?
)