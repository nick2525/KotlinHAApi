package ru.nick252.types.results.services

data class ServicesNumber(
    val min: Double?,
    val max: Double?,
    val step: Double?,
    val unitOfMeasurement: String?,
    val mode: String?
)