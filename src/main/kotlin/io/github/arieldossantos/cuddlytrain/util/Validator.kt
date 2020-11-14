package io.github.arieldossantos.cuddlytrain.util

import io.github.arieldossantos.cuddlytrain.exceptions.APIException
import java.lang.RuntimeException

/**
 * Object validator
 *
 * This object does general validations of the software
 *
 * @author Ariel Reis
 */
object Validator {
    /**
     * Validate an user ID
     *
     * It checks if user ID is greater than or equal 1000
     * or
     * less than or equal 100.000
     *
     * @param id member id
     */
    open fun validateId(id: Int) {
        when {
            id < 1000   -> throw APIException("O id do usuário é inválido, por ser menor que o permitido")
            id > 100000 -> throw APIException("O id do usuário é inválido, por ser maior que o permitido")
        }
    }
}
