package ru.nick252.types.server

import ru.nick252.types.ServerTypes
import ru.nick252.types.SocketMessage

data class AuthInvalidMessage(val message: String? = null) : SocketMessage(ServerTypes.AUTH_INVALID)