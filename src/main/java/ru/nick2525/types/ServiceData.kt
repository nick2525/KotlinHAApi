package ru.nick2525.types

import ru.nick2525.types.ServiceData

class ServiceData {
    var entityId: String? = null
        private set

    fun setEntityId(entityId: String?): ServiceData {
        this.entityId = entityId
        return this
    }

    constructor() {}
    constructor(entityId: String?) {
        this.entityId = entityId
    }
}