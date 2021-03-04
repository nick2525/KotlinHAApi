package ru.nick2525.types

class Context {
    private var id: String? = null
    private var parentId: String? = null
    private var userId: String? = null

    constructor() {}
    constructor(id: String?, parentId: String?, userId: String?) {
        this.id = id
        this.parentId = parentId
        this.userId = userId
    }
}