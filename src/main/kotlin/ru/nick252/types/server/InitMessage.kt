package ru.nick252.types.server

import ru.nick252.types.SocketMessage
import ru.nick252.types.ServerTypes

data class InitMessage(val haVersion: String? = null) : SocketMessage(ServerTypes.AUTH_REQUIRED)