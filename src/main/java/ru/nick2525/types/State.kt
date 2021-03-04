package ru.nick2525.types

class State {
    var entityId: String? = null
        private set
    var state: String? = null
        private set
    var attributes: Attributes? = null
        private set
    var lastChanged: String? = null
        private set
    var lastUpdated: String? = null
        private set
    var context: Context? = null
        private set

    constructor() {}
    constructor(
        entityId: String?,
        state: String?,
        attributes: Attributes?,
        lastChanged: String?,
        lastUpdated: String?,
        context: Context?
    ) {
        this.entityId = entityId
        this.state = state
        this.attributes = attributes
        this.lastChanged = lastChanged
        this.lastUpdated = lastUpdated
        this.context = context
    }
}