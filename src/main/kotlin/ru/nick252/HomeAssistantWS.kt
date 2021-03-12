package ru.nick252

import org.java_websocket.client.WebSocketClient
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.DeserializationFeature
import ru.nick252.types.server.InitMessage
import ru.nick252.types.Client.AuthMessage
import ru.nick252.types.server.AuthInvalidMessage
import ru.nick252.types.server.ResultMessage
import ru.nick252.types.server.SubscriptionMessage
import ru.nick252.types.server.ServerMessage
import ru.nick252.types.Client.ClientMessage
import org.java_websocket.handshake.ServerHandshake
import ru.nick252.types.SocketMessage
import ru.nick252.types.ServerTypes
import java.lang.Exception
import java.net.URI
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import ru.nick252.types.Client
import ru.nick252.types.results.ConfigResultMessage
import ru.nick252.types.results.StatesResultMessage
import ru.nick252.types.server.MessageId

abstract class HomeAssistantWS(serverUri: URI?, private val token: String) {
    private val socket: WebSocketClient
    private var messages = 1
    private fun getJackson(failOnUnknowns: Boolean = false): ObjectMapper {
        val om = jacksonObjectMapper()
        om.propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknowns)
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
        return om
    }

    val nextMessageId: Int
        get() = messages++
    val isClosed: Boolean
        get() = socket.isClosed
    val isClosing: Boolean
        get() = socket.isClosing
    val isFlushAndClose: Boolean
        get() = socket.isFlushAndClose
    val isOpen: Boolean
        get() = socket.isOpen

    fun close() {
        socket.close()
    }

    fun connect() {
        socket.connect()
    }

    fun onAuthRequired(message: InitMessage?) {
        try {
            socket.send(getJackson().writeValueAsString(AuthMessage(token)))
        } catch (ex: Exception) {
            System.err.println("onAuthRequired:" + ex.message)
        }
    }

    abstract fun onAuthInvalid(message: AuthInvalidMessage?)
    abstract fun onAuthOk()
    abstract fun onResult(resultMessage: ServerMessage?)
    abstract fun onSubscriptionMessage(message: SubscriptionMessage?)
    fun onPong(message: ServerMessage?) {}
    private val request = mutableMapOf<Int, ClientMessage>()
    fun send(message: ClientMessage) {
        try {
            socket.send(getJackson().writeValueAsString(message))
            request.put(message.id, message)
        } catch (ex: Exception) {
            System.err.println("send:" + ex.message)
        }
    }

    init {
        socket = object : WebSocketClient(serverUri) {
            override fun onOpen(handshakedata: ServerHandshake) {
                println("Socket_Opened")
            }

            override fun onMessage(message: String) {
                println("Socket_Message: $message")
                try {
                    val messageObj = getJackson().readValue(message, SocketMessage::class.java)
                    when (messageObj.type) {
                        ServerTypes.AUTH_REQUIRED -> onAuthRequired(
                            getJackson().readValue(
                                message,
                                InitMessage::class.java
                            )
                        )
                        ServerTypes.AUTH_INVALID -> onAuthInvalid(
                            getJackson().readValue(
                                message,
                                AuthInvalidMessage::class.java
                            )
                        )
                        ServerTypes.AUTH_OK -> onAuthOk()
                        ServerTypes.RESULT -> onResult(parseResult(message))
                        ServerTypes.EVENT -> onSubscriptionMessage(
                            getJackson().readValue(
                                message,
                                SubscriptionMessage::class.java
                            )
                        )
                        ServerTypes.PONG -> onPong(getJackson().readValue(message, ServerMessage::class.java))
                    }
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }

            override fun onClose(code: Int, reason: String, remote: Boolean) {
                println("Socket_Closed: $code - $reason - $remote")
            }

            override fun onError(ex: Exception) {
                println("Socket_Error: " + ex.message)
                ex.fillInStackTrace()
            }
        }
    }

    private fun parseResult(message: String): ServerMessage {
        val id = getJackson().readValue(
            message,
            MessageId::class.java
        ).id

        val parseClass = when (request[id]) {
            is Client.GetStatesMessage -> StatesResultMessage::class.java
            is Client.GetConfigMessage -> ConfigResultMessage::class.java
            else -> ResultMessage::class.java
        }
        request.remove(id)
        return getJackson().readValue(
            message,
            parseClass
        )

    }

}