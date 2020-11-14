package io.github.arieldossantos.cuddlytrain.util

import io.github.arieldossantos.cuddlytrain.exceptions.APIException
import org.junit.Assert
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
            Assert.assertTrue(e is APIException)
        }
    }

    /**
     * Checks id validator success returns Unit
     */
    @Test
    fun testIdValidatorSuccess() {
        val success = Validator.validateId(successfulConst)
        Assert.assertSame(success, Unit)
    }
}
