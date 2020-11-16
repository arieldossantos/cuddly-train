package io.github.arieldossantos.cuddlytrain.utils

import io.github.arieldossantos.cuddlytrain.exceptions.APIException

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


    /**
     * Validate a month number
     *
     * It is valid between 1 and 12
     *
     *
     * @param month month number
     */
    open fun validateMonth(month: Int) {
        when {
            month < 1     -> throw APIException("O mês informado é inválido, não existe mês com valor menor que 1")
            month > 12    -> throw APIException("O mês informado é inválido, não existe mês com valor maior que 12")
        }
    }
}
