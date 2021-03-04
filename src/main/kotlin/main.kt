import ru.nick2525.HomeAssistantWS
import ru.nick2525.types.Client
import ru.nick2525.types.server.AuthInvalidMessage
import ru.nick2525.types.server.ResultMessage
import ru.nick2525.types.server.SubscriptionMessage
import java.net.URI

fun main(args: Array<String>) {

    lateinit var ws: HomeAssistantWS
    ws = object : HomeAssistantWS(URI.create(""), "") {
        override fun onAuthInvalid(message: AuthInvalidMessage?) {

        }

        override fun onAuthOk() {
            ws.send(Client.GetStatesMessage(101))
        }

        override fun onResult(resultMessage: ResultMessage?) {
        }

        override fun onSubscriptionMessage(message: SubscriptionMessage?) {
        }

    }
    ws.connect()
}