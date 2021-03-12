package ru.nick252.types.results

import com.fasterxml.jackson.annotation.JsonProperty
import ru.nick252.types.ServerTypes
import ru.nick252.types.server.ServerMessage

data class ConfigResultMessage(
    @JsonProperty("id") var  id: Int,
    @param:JsonProperty("success") val success: Boolean,
    @param:JsonProperty("result") val result: List<ConfigResult>
) : ServerMessage(ServerTypes.RESULT, id)