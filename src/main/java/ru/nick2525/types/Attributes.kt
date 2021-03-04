package ru.nick2525.types

class Attributes {
    var friendlyName: String? = null
        private set
    var unitOfMeasurement: String? = null
        private set

    constructor()
    constructor(unitOfMeasurement: String?, friendlyName: String?) {
        this.unitOfMeasurement = unitOfMeasurement
        this.friendlyName = friendlyName
    }
}