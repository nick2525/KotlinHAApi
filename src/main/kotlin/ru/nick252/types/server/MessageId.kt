package ru.nick252.types.server

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageId(@JsonProperty("id") var  id: Int)