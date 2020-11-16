package io.github.arieldossantos.cuddlytrain

import io.github.arieldossantos.cuddlytrain.controller.TransactionController
import io.github.arieldossantos.cuddlytrain.exceptions.APIException
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.arieldossantos.cuddlytrain.responses.ErrorResponse
import io.ktor.gson.gson
import java.lang.Integer.parseInt
import java.text.DateFormat

/**
 * Server file
 *
 * Here are the conf of server
 *
 * @author Ariel Reis
 */

/** Locations definitions **/
//Index
@Location("/")
class index()
//Transactions
@Location("/{userId}/transactions/{year}/{month}")
open class TransactionRequest(val userId: Int, val year: Int, val month: Int)


//Create app module
fun Application.module() {
    //Add default headers
    install(DefaultHeaders)
    install(Locations)

    //Add json content support for classes with Gson
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }

    //Add default error handler
    install(StatusPages) {
        //Default api exception (BadRequest)
        exception<APIException> {
            call.respond(
                HttpStatusCode.BadRequest,
                ErrorResponse(it.localizedMessage)
            )
        }
    }

    //Add routing to module
    install(Routing) {
        //Index context definition
        get<index> {
            call.respondRedirect("https://github.com/arieldossantos/cuddly-train/blob/main/README.md", permanent = true)
        }
        //Transaction context definition
        get<TransactionRequest> {
            request -> call.respond(
                TransactionController.returnUserTransactions(request)
            )
        }
    }
}

/**
 * Get port from env or default
 */
private fun getPort(): Int {
    val port = System.getenv("PORT")
    return if (!port.isNullOrEmpty()) {
        parseInt(port)
    } else {
        8080
    }
}

//Main function of server :)
fun main() {
    embeddedServer(
        Netty,
        port = getPort(),
        module = Application::module
    ).start()
}
