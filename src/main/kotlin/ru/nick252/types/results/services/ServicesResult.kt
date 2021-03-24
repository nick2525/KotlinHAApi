package ru.nick252.types.results.services

data class ServicesResult(
    val homeassistant: ServicesHomeassistant?,
    val persistentNotification: ServicesPersistentNotification?,
    val recorder: ServicesRecorder?,
    val logger: ServicesLogger?,
    val systemLog: ServicesSystemLog?,
    val mqtt: ServicesMqtt?,
    val cloud: ServicesCloud
)