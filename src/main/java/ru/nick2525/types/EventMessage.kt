package ru.nick2525.types

import ru.nick2525.types.EventData

class EventMessage {
    var eventType: String? = null
        private set
    var data: EventData? = null
        private set
    var origin: String? = null
        private set
    var timeFired: String? = null
        private set
    var context: Context? = null
        private set

    constructor()
    constructor(eventType: String?, data: EventData?, origin: String?, timeFired: String?, context: Context?) {
        this.eventType = eventType
        this.data = data
        this.origin = origin
        this.timeFired = timeFired
        this.context = context
    }
}