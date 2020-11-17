package io.github.arieldossantos.cuddlytrain.controllers.transactions

import io.github.arieldossantos.cuddlytrain.controllers.exceptions.APIException
import io.github.arieldossantos.cuddlytrain.controllers.exceptions.InvalidMonthException
import io.github.arieldossantos.cuddlytrain.controllers.exceptions.InvalidUserIdException

/**
 * Object validator
 *
 * This object does general validations of the software
 *
 * @author Ariel Reis
 */
object TransactionValidator {
    /**
     * Validate an user ID
     *
     * It checks if user ID is greater than or equal 1000
     * or
     * less than or equal 100.000
     *
     * @param id member id
     */
    fun validateId(id: Int): Unit = when {
        id < 1000   -> throw InvalidUserIdException("O id do usuário é inválido, por ser menor que o permitido")
        id > 100000 -> throw InvalidUserIdException("O id do usuário é inválido, por ser maior que o permitido")
        else -> Unit
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
        if (month < 1 || month > 12) throw InvalidMonthException("O mês informado é inválido")
    }
}
