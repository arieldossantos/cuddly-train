package io.github.arieldossantos.cuddlytrain

import io.github.arieldossantos.cuddlytrain.controller.TransactionController
import io.github.arieldossantos.cuddlytrain.exceptions.APIExceptions
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
@Location("/{id}/transactions/{year}/{month}")
open class Transaction (val id: Int, val year: Int, val month: Int)


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
        exception<APIExceptions> {
            print(it.localizedMessage)
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
            call.respondText("Hello world", ContentType.Text.Html)
        }
        //Transaction context definition
        get<Transaction> {
            transaction -> call.respondText(
                TransactionController.returnUserTransactions(transaction),
                ContentType.Text.Html
            )
        }
    }
}

//Main function of server :)
fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        module = Application::module
    ).start()
}
