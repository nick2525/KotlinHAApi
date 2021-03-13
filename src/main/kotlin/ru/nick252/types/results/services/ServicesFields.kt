package ru.nick252.types.results.services

data class ServicesFields(
    val latitude: ServicesCoordinates?,
    val longitude: ServicesCoordinates?,
    val message: ServicesDescriptionExample?,
    val title: ServicesDescriptionExample?,
    val notificationId: ServicesDescriptionExample?
)