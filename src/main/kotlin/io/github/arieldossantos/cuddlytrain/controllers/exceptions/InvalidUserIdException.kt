package io.github.arieldossantos.cuddlytrain.controllers.exceptions

import io.ktor.http.HttpStatusCode

class InvalidUserIdException(message: String) : APIException(HttpStatusCode.BadRequest, message)
