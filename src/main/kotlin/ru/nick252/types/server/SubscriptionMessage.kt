package ru.nick252.types.server

import ru.nick252.types.EventMessage
import ru.nick252.types.ServerTypes

data class SubscriptionMessage(val id: Int, val event: EventMessage?) : ServerMessage(ServerTypes.EVENT, id)