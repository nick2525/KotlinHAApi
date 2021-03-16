package ru.nick252.types.results.services

data class ServicesRecorder(
    val purge: ServicesNameDescriptionFields?,
    val enable: ServicesNameDescriptionFields?,
    val disable: ServicesNameDescriptionFields?
)