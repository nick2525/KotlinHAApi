package ru.nick252.types.results.services

import com.fasterxml.jackson.annotation.JsonProperty

data class ServicesFields(
    val latitude: ServicesCoordinates?,
    val longitude: ServicesCoordinates?,
    val message: ServicesDescriptionExample?,
    val title: ServicesDescriptionExample?,
    val notificationId: ServicesDescriptionExample?,
    val keepDays: ServicesKeepDays?,
    val repack: ServicesDescriptionExample?,
    val level: ServicesDescriptionExample?,
    @JsonProperty("homeassistant.core") val homeassistantCore: ServicesDescriptionExample?,
    @JsonProperty("homeassistant.components.mqtt") val homeassistantComponentsMqtt: ServicesDescriptionExample?,
    @JsonProperty("custom_components.my_integration") val customComponentsMyIntegration: ServicesDescriptionExample?,
    val aiohttp: ServicesDescriptionExample?,
    val logger: ServicesLogger?,
    val topic: ServicesDescriptionExample?,
    val payload: ServicesDescriptionExample?,
    val payloadTemplate: ServicesDescriptionExample?,
    val qos: ServicesDescriptionExample?,
    val retain: ServicesDescriptionExample?,
    val duration: ServicesDescriptionExample?
)