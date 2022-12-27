package todo.com.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable
import java.io.File

fun Application.configureRouting() {

    routing {
        get("/") {
            val userInfo = UserInfo("email@abc.com","mypassword")
            call.response.headers.append("server-type","ktor-server")
            call.response.headers.append("response-type","json")

            /* println("Uri is ${call.request.uri}")
             println("header are ${call.request.headers.names()}")
             println("header are ${call.request.headers["User-Agent"]}")
             //http://127.0.0.1:8080/?name=abdul&email=androidworkshops@gmail.com
             println("Name is ${call.request.queryParameters["name"]}")
             println("Email is ${call.request.queryParameters["email"]}")*/
            //call.respond(userInfo)


            call.respondText("headers attached")
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

        get ("/download"){
            val file = File("files/scenary.jpg")
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Attachment.withParameter(
                    ContentDisposition.Parameters.FileName,
                    "ktor-image.jpg"
                ).toString()
            )
            call.respondFile(file)
        }

        get ("/fileOpen"){
            val file = File("files/scenary.jpg")
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Inline.withParameter(
                    ContentDisposition.Parameters.FileName,
                    "ktor-image.jpg"
                ).toString()
            )
            call.respondFile(file)
        }

    }
}

@Serializable
data class UserInfo(
    val email: String,
    val password:String
)
