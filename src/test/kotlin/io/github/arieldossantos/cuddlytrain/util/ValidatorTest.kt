package io.github.arieldossantos.cuddlytrain.util

import io.github.arieldossantos.cuddlytrain.exceptions.APIExceptions
import org.junit.Test

val errorConst = 123
val successfulConst = 1234

class ValidatorTest {
    /**
     * Checks id validator ERROR
     */
    @Test
    fun testIdValidatorError() {
        try{
            Validator.validateId(errorConst)
        } catch (e: Exception) {
            assert(e is APIExceptions)
        }
    }

    fun testIdValidatorSuccess() {
        TODO("Criar teste de validação do ID aqui")
    }
}
