package ru.nick252.types

import ru.nick252.types.server.Forecast

data class Attributes(
    val friendlyName: String?,
    val unitOfMeasurement: String?,
    val supportedFeatures: Int,
    val codeFormat: String?,
    val changedBy: String?,
    val codeArmRequired: String?,
    val prePendingState: String?,
    val postPendingState: String?,
    val nextDawn: String?,
    val nextDusk: String?,
    val deviceClass: String?,
    val temperature: Double?,
    val icon: String?,
    val lastTriggered: String?,
    val nextMidnight: String?,
    val currentPosition: Byte?,
    val batteryVoltage: Float?,
    val nextNoon: String?,
    val pressure: Float?,
    val windBearing: Float?,
    val windSpeed: Float?,
    val attribution: String?,
    val forecast: List<Forecast>?,
    val releaseNotes: String?,
    val nextSetting: String?
)