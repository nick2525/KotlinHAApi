package ru.nick252.types.results.services

data class ServicesMqtt(
    val publish: ServicesPublish,
    val dump: ServicesDescriptionExample?,
    val reload: ServicesDescriptionExample?
)