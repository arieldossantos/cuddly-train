package io.github.arieldossantos.cuddlytrain

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

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
@Location("/{id}/transactions/{year}/{month")
class Transaction (val id: Int, val year: Int, val month: Int)


//Create app module
fun Application.module() {
    //Add default headers
    install(DefaultHeaders)
    install(Locations)
    //Add routing to module
    install(Routing) {
        get<index> {
            call.respondText("Hello world", ContentType.Text.Html)
        }
        get<Transaction> {
            transaction -> call.respondText("{}", ContentType.Application.Json)
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
