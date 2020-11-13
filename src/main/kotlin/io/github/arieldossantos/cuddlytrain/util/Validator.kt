package io.github.arieldossantos.cuddlytrain.util

import io.github.arieldossantos.cuddlytrain.exceptions.APIExceptions
import java.lang.RuntimeException

object Validator {
    open fun validateId(id: Int) {
        if (id < 1000 || id > 100000) {
            throw APIExceptions("O id não pode ser utilizado por não estar nos padrões necessários.")
        }
    }
}
