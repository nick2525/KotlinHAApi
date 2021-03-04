package ru.nick252.types.server

import ru.nick252.types.SocketMessage
import ru.nick252.types.ServerTypes

class AuthInvalidMessage : SocketMessage {
    var message: String? = null
        private set

    constructor()
    constructor(message: String?) : super(ServerTypes.AUTH_INVALID) {
        this.message = message
    }
}