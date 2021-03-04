package ru.nick252.types.server

import ru.nick252.types.EventMessage
import ru.nick252.types.ServerTypes

class SubscriptionMessage : ServerMessage {
    var event: EventMessage? = null
        private set

    constructor()
    constructor(id: Int, event: EventMessage?) : super(ServerTypes.EVENT, id) {
        this.event = event
    }
}