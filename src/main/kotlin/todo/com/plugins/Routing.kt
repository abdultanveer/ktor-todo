package todo.com.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            println("Uri is ${call.request.uri}")
            println("header are ${call.request.headers.names()}")
            println("header are ${call.request.headers["User-Agent"]}")

            call.respondText("Hello todo tcs!")
        }
    }
}
