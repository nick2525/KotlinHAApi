package ru.nick252.types.results.services

import com.fasterxml.jackson.annotation.JsonProperty
import ru.nick252.types.ServerTypes
import ru.nick252.types.server.ServerMessage

data class ServicesResultMessage(
    @JsonProperty("id") var  id: Int,
    @param:JsonProperty("success") val success: Boolean,
    @param:JsonProperty("result") val result: List<ServicesResult>
) : ServerMessage(ServerTypes.RESULT, id)