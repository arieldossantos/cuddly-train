package io.github.arieldossantos.cuddlytrain.controllers.exceptions

import io.ktor.http.HttpStatusCode

/**
 * Api exceptions here
 *
 * @param message Message is the description of error, will be described on API return
 */
open class APIException(val statusCode: HttpStatusCode, message: String) : Exception(message)
