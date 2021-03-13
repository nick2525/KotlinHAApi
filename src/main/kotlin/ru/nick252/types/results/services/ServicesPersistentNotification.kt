package ru.nick252.types.results.services

data class ServicesPersistentNotification(
    val create: ServicesNameTarget?,
    val dismiss: ServicesNameDescriptionFields?,
    val markRead: ServicesNameDescriptionFields?
)