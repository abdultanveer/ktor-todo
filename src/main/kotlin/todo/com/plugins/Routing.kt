package todo.com.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {

    routing {
        get("/") {
            println("Uri is ${call.request.uri}")
            println("header are ${call.request.headers.names()}")
            println("header are ${call.request.headers["User-Agent"]}")
            //http://127.0.0.1:8080/?name=abdul&email=androidworkshops@gmail.com
            println("Name is ${call.request.queryParameters["name"]}")
            println("Email is ${call.request.queryParameters["email"]}")


            call.respondText("Hello todo tcs!")
        }

        //http://127.0.0.1:8080/notes/2
        get("/notes/{noteId}") {
            val noteNo = call.parameters["noteId"]
            call.respondText("your note no is $noteNo")
        }

        post("/login") {
            val userInfo = call.receive<UserInfo>()
            println(userInfo)
            call.respondText("this is working")
        }
    }
}

@Serializable
data class UserInfo(
    val email: String,
    val password:String
)
