package io.github.arieldossantos.cuddlytrain

import com.fasterxml.jackson.databind.SerializationFeature
import io.github.arieldossantos.cuddlytrain.controllers.transactions.TransactionController
import io.github.arieldossantos.cuddlytrain.controllers.exceptions.APIException
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.arieldossantos.cuddlytrain.controllers.responses.ErrorResponse
import io.ktor.jackson.*
import java.lang.Integer.parseInt

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
@Location("/{userId}/transacoes/{year}/{month}")
open class TransactionRequest(val userId: Int, val year: Int, val month: Int)


//Create app module
fun Application.module() {
    //Add default headers
    install(DefaultHeaders)
    install(Locations)

    //Add json content support for classes with Gson
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)

        }
    }

    //Add default error handler
    install(StatusPages) {
        //Default api exception (BadRequest)
        exception<APIException> {
            call.respond(
                it.statusCode,
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
