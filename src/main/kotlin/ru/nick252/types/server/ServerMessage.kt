package ru.nick252.types.server

import ru.nick252.types.SocketMessage

open class ServerMessage(type: String? = "", id: Int = 0) : SocketMessage(type)