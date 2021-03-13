package ru.nick252.types.results.config

data class ConfigResult(
    val latitude: Double?,
    val longitude: Double?,
    val elevation: Int,
    val unitSystem: ConfigUnitSystem?,
    val locationName: String?,
    val timeZone: String?,
    val components: List<String>?,
    val configDir: String?,
    val whitelistExternalDirs: List<String>?,
    val allowlistExternalDirs: List<String>?,
    val allowlistExternalUrls: List<String>?,
    val version: String?,
    val configSource: String?,
    val safeMode: Boolean?,
    val state: String?,
    val externalUrl: String?,
    val internalUrl: String?
)