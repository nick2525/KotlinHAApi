import ru.nick252.HomeAssistantWS
import ru.nick252.types.Client
import ru.nick252.types.server.AuthInvalidMessage
import ru.nick252.types.server.ResultMessage
import ru.nick252.types.server.SubscriptionMessage
import java.net.URI

fun main(args: Array<String>) {

    lateinit var ws: HomeAssistantWS
    ws = object : HomeAssistantWS(URI.create(""), "") {
        override fun onAuthInvalid(message: AuthInvalidMessage?) {
            message.toString()
        }

        override fun onAuthOk() {
            ws.send(Client.GetStatesMessage(101))
        }

        override fun onResult(resultMessage: ResultMessage?) {
            resultMessage.toString()
        }

        override fun onSubscriptionMessage(message: SubscriptionMessage?) {
        }

    }
    ws.connect()
}