package ru.nick252.types

object Client {
    const val AUTH = "auth"
    const val SUBSCRIBE_EVENTS = "subscribe_events"
    const val UNSUBSCRIBE_EVENTS = "unsubscribe_events"
    const val CALL_SERVICE = "call_service"
    const val GET_STATES = "get_states"
    const val GET_CONFIG = "get_config"
    const val GET_SERVICES = "get_services"
    const val GET_PANELS = "get_panels"

    const val CAMERA_THUMBNAIL = "camera_thumbnail"
    const val MEDIA_PLAYER_THUMBNAIL = "media_player_thumbnail"
    const val PING = "ping"

    class AuthMessage(val accessToken: String) : SocketMessage(AUTH)
    abstract class ClientMessage(type: String?, val id: Int) : SocketMessage(type)
    class SubscribeEvents(id: Int) : ClientMessage(SUBSCRIBE_EVENTS, id) {
        var eventType: String = ""
            private set

        fun setEventType(eventType: String): SubscribeEvents {
            this.eventType = eventType
            return this
        }
    }

    class UnsubscribeEvents(id: Int, val subscription: Int) : ClientMessage(UNSUBSCRIBE_EVENTS, id)
    class CallServiceMessage(id: Int, val domain: String, val service: String) : ClientMessage(CALL_SERVICE, id) {
        var serviceData: ServiceData? = null
            private set

        fun setServiceData(serviceData: ServiceData?): CallServiceMessage {
            this.serviceData = serviceData
            return this
        }
    }

    class GetStatesMessage(id: Int) : ClientMessage(GET_STATES, id)
    class GetConfigMessage(id: Int) : ClientMessage(GET_CONFIG, id)
    class GetServicesMessage(id: Int) : ClientMessage(GET_SERVICES, id)
    class GetPanelsMessage(id: Int) : ClientMessage(GET_PANELS, id)
    open class ClientEntityMessage(type: String?, id: Int, val entityId: String) : ClientMessage(type, id)

    class CameraThumbnailMessage(id: Int, entityId: String) : ClientEntityMessage(
        CAMERA_THUMBNAIL, id, entityId
    )

    class MediaPlayerThumbnailMessage(id: Int, entityId: String) :
        ClientEntityMessage(MEDIA_PLAYER_THUMBNAIL, id, entityId)

    class PingMessage(id: Int) : ClientMessage(PING, id)
}