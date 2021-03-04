package ru.nick2525.types.server

import ru.nick2525.types.SocketMessage

open class ServerMessage : SocketMessage {
    /**
     * Contains the client message sources id
     * @return the id of the message causing this reply
     */
    var id = 0
        private set

    constructor()
    constructor(type: String?, id: Int) : super(type) {
        this.id = id
    }
}