package ru.nick2525.types

open class SocketMessage {
    /**
     * Get the type of the message as a string
     * @return String containing the type
     */
    var type: String? = null
        private set

    constructor() {}
    constructor(type: String?) {
        this.type = type
    }
}