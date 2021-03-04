package ru.nick2525

import org.java_websocket.client.WebSocketClient
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.DeserializationFeature
import ru.nick2525.types.Server.InitMessage
import ru.nick2525.types.Client.AuthMessage
import ru.nick2525.types.Server.AuthInvalidMessage
import ru.nick2525.types.Server.ResultMessage
import ru.nick2525.types.Server.SubscriptionMessage
import ru.nick2525.types.Server.ServerMessage
import ru.nick2525.types.Client.ClientMessage
import org.java_websocket.handshake.ServerHandshake
import ru.nick2525.types.SocketMessage
import ru.nick2525.types.ServerTypes
import java.lang.Exception
import java.net.URI

abstract class HomeAssistantWS(serverUri: URI?, private val token: String) {
    private val socket: WebSocketClient
    private var messages = 1
    private fun getJackson(failOnUnknowns: Boolean): ObjectMapper {
        val om = ObjectMapper()
        om.propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknowns)
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
            socket.send(getJackson(true).writeValueAsString(AuthMessage(token)))
        } catch (ex: Exception) {
            System.err.println("onAuthRequired:" + ex.message)
        }
    }

    abstract fun onAuthInvalid(message: AuthInvalidMessage?)
    abstract fun onAuthOk()
    abstract fun onResult(resultMessage: ResultMessage?)
    abstract fun onSubscriptionMessage(message: SubscriptionMessage?)
    fun onPong(message: ServerMessage?) {}
    fun send(message: ClientMessage?) {
        try {
            socket.send(getJackson(true).writeValueAsString(message))
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
                    val messageObj = getJackson(false).readValue(message, SocketMessage::class.java)
                    when (messageObj.type) {
                        ServerTypes.AUTH_REQUIRED -> onAuthRequired(
                            getJackson(true).readValue(
                                message,
                                InitMessage::class.java
                            )
                        )
                        ServerTypes.AUTH_INVALID -> onAuthInvalid(
                            getJackson(true).readValue(
                                message,
                                AuthInvalidMessage::class.java
                            )
                        )
                        ServerTypes.AUTH_OK -> onAuthOk()
                        ServerTypes.RESULT -> onResult(getJackson(true).readValue(message, ResultMessage::class.java))
                        ServerTypes.EVENT -> onSubscriptionMessage(
                            getJackson(true).readValue(
                                message,
                                SubscriptionMessage::class.java
                            )
                        )
                        ServerTypes.PONG -> onPong(getJackson(true).readValue(message, ServerMessage::class.java))
                    }
                } catch (ex: Exception) {
                    System.err.println("onMessage:" + ex.message)
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
}