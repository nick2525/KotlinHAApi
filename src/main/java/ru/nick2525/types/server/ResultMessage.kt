package ru.nick2525.types.server

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import ru.nick2525.types.Result
import ru.nick2525.types.ServerTypes

class ResultMessage @JsonCreator constructor(
    @JsonProperty("id") id: Int,
    @param:JsonProperty("success") val success: Boolean,
    @param:JsonProperty("result") val result: Result
) : ServerMessage(ServerTypes.RESULT, id)