package ru.nick252.types

class UnitSystem {
    var length: String? = null
        private set
    var mass: String? = null
        private set
    var pressure: String? = null
        private set
    var temperature: String? = null
        private set
    var volume: String? = null
        private set

    fun setLength(length: String?): UnitSystem {
        this.length = length
        return this
    }

    fun setMass(mass: String?): UnitSystem {
        this.mass = mass
        return this
    }

    fun setPressure(pressure: String?): UnitSystem {
        this.pressure = pressure
        return this
    }

    fun setTemperature(temperature: String?): UnitSystem {
        this.temperature = temperature
        return this
    }

    fun setVolume(volume: String?): UnitSystem {
        this.volume = volume
        return this
    }
}