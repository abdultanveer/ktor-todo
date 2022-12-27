package todo.com

import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import todo.com.plugins.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.*
import io.ktor.serialization.kotlinx.json.*


fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0", module = Application::module)

        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation){
        json()
    }
    configureRouting()
}
