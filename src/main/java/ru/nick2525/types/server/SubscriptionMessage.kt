package ru.nick2525.types.server

import ru.nick2525.types.EventMessage
import ru.nick2525.types.ServerTypes

class SubscriptionMessage : ServerMessage {
    var event: EventMessage? = null
        private set

    constructor() {}
    constructor(id: Int, event: EventMessage?) : super(ServerTypes.EVENT, id) {
        this.event = event
    }
}