package ru.nick252.types.server

data class Forecast(
    val condition: String? = null,
    val precipitation: Float? = null,
    val precipitationProbability: Float?,
    val temperature: Float?,
    val templow: Float? = null,
    val datetime: String? = null,
    val windBearing: Float? = null,
    var windSpeed: Float? = null
)