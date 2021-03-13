package ru.nick252.types.results.services

data class ServicesHomeassistant(
    val turnOff: ServicesNameTarget?,
    val turnOn: ServicesNameTarget?,
    val toggle: ServicesNameTarget?,
    val stop: ServicesNameTarget?,
    val restart: ServicesNameTarget?,
    val checkConfig: ServicesNameTarget?,
    val updateEntity: ServicesNameTarget?,
    val reloadCoreConfig: ServicesNameTarget?,
    val setLocation: ServicesNameTarget?
)