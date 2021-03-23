package ru.nick252.types.results.services

data class ServicesDescriptionExample(
    val description: String?,
    val example: String?,
    val name: String?,
    val default: String?,
    val selector: ServicesSelector?,
    val fields: ServicesFields?,
    val required: String?,
    val advanced: Boolean?,
    val values: List<Double>?
)