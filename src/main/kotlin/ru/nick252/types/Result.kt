package ru.nick252.types

data class Result(
    val context: Context?,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val elevation: Long = 0,
    val unitSystem: UnitSystem?,
    val locationName: String?,
    val timeZone: String? = null,
    val components: List<String>?,
    val configDir: String? = null,
    val whitelistExternalDirs: List<String>?,
    val allowlistExternalDirs: List<String>?,
    val allowlistExternalUrls: List<String>?,
    val version: String? = null,
    val configSource: String?,
    val isSafeMode: Boolean = false,
    val state: String? = null,
    val externalUrl: String?,
    val internalUrl: String?,
    val entity_id: String?,
    val attributes: Attributes?,
    val lastChanged: String?,
    val lastUpdated: String?
)