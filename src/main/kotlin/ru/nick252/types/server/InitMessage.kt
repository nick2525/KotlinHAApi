package ru.nick252.types.server

import ru.nick252.types.SocketMessage
import ru.nick252.types.ServerTypes

class InitMessage : SocketMessage {
    var haVersion: String? = null
        private set

    constructor()
    constructor(haVersion: String?) : super(ServerTypes.AUTH_REQUIRED) {
        this.haVersion = haVersion
    }
}