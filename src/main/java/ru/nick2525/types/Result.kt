package ru.nick2525.types

import ru.nick2525.types.UnitSystem

//@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
class Result {
    var context: Context? = null
        private set
    var latitude = 0.0
        private set
    var longitude = 0.0
        private set
    var elevation = 0
        private set

    //    @JsonIgnoreProperties(ignoreUnknown = true)
    var unitSystem: UnitSystem? = null
        private set
    var locationName: String? = null
        private set
    var timeZone: String? = null
        private set
    var components: List<String>? = null
        private set
    var configDir: String? = null
        private set
    var whitelistExternalDirs: List<String>? = null
        private set
    var allowlistExternalDirs: List<String>? = null
        private set
    var allowlistExternalUrls: List<String>? = null
        private set
    var version: String? = null
        private set
    var configSource: String? = null
        private set
    var isSafeMode = false
        private set
    var state: String? = null
        private set
    var externalUrl: String? = null
        private set
    var internalUrl: String? = null
        private set

    fun setContext(context: Context?): Result {
        this.context = context
        return this
    }

    fun setLatitude(latitude: Double): Result {
        this.latitude = latitude
        return this
    }

    fun setLongitude(longitude: Double): Result {
        this.longitude = longitude
        return this
    }

    fun setElevation(elevation: Int): Result {
        this.elevation = elevation
        return this
    }

    fun setUnitSystem(unitSystem: UnitSystem?): Result {
        this.unitSystem = unitSystem
        return this
    }

    fun setLocationName(locationName: String?): Result {
        this.locationName = locationName
        return this
    }

    fun setTimeZone(timeZone: String?): Result {
        this.timeZone = timeZone
        return this
    }

    fun setComponents(components: List<String>?): Result {
        this.components = components
        return this
    }

    fun setConfigDir(configDir: String?): Result {
        this.configDir = configDir
        return this
    }

    fun setWhitelistExternalDirs(whitelistExternalDirs: List<String>?): Result {
        this.whitelistExternalDirs = whitelistExternalDirs
        return this
    }

    fun setAllowlistExternalDirs(allowlistExternalDirs: List<String>?): Result {
        this.allowlistExternalDirs = allowlistExternalDirs
        return this
    }

    fun setAllowlistExternalUrls(allowlistExternalUrls: List<String>?): Result {
        this.allowlistExternalUrls = allowlistExternalUrls
        return this
    }

    fun setVersion(version: String?): Result {
        this.version = version
        return this
    }

    fun setConfigSource(configSource: String?): Result {
        this.configSource = configSource
        return this
    }

    fun setSafeMode(safeMode: Boolean): Result {
        isSafeMode = safeMode
        return this
    }

    fun setState(state: String?): Result {
        this.state = state
        return this
    }

    fun setExternalUrl(externalUrl: String?): Result {
        this.externalUrl = externalUrl
        return this
    }

    fun setInternalUrl(internalUrl: String?): Result {
        this.internalUrl = internalUrl
        return this
    }
}