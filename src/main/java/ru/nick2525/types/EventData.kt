package ru.nick2525.types

class EventData {
    var entityId: String? = null
        private set
    var oldState: State? = null
        private set
    var newState: State? = null
        private set

    constructor()
    constructor(entityId: String?, oldState: State?, newState: State?) {
        this.entityId = entityId
        this.oldState = oldState
        this.newState = newState
    }
}