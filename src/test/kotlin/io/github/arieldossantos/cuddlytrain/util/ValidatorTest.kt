package io.github.arieldossantos.cuddlytrain.util

import io.github.arieldossantos.cuddlytrain.exceptions.APIException
import org.junit.Assert
import org.junit.Test


class ValidatorTest {
    private val ERROR = 123
    private val SUCCESS = 1234
    /**
     * Checks id validator ERROR
     */
    @Test
    fun testIdValidatorError() {
        try{
            Validator.validateId(ERROR)
        } catch (e: Exception) {
            Assert.assertTrue(e is APIException)
        }
    }

    /**
     * Checks id validator success returns Unit
     */
    @Test
    fun testIdValidatorSuccess() {
        val success = Validator.validateId(SUCCESS)
        Assert.assertSame(success, Unit)
    }
}
