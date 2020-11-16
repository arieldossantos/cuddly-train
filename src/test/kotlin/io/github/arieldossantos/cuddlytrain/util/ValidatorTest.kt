package io.github.arieldossantos.cuddlytrain.util

import io.github.arieldossantos.cuddlytrain.exceptions.APIException
import org.junit.Assert
import org.junit.Test


class ValidatorTest {
    private val ERRORID = 123
    private val SUCCESSID = 1234
    /**
     * Checks id validator ERROR
     */
    @Test
    fun testIdValidatorError() {
        try{
            Validator.validateId(ERRORID)
        } catch (e: Exception) {
            Assert.assertTrue(e is APIException)
        }
    }

    /**
     * Checks id validator success returns Unit
     */
    @Test
    fun testIdValidatorSuccess() {
        val success = Validator.validateId(SUCCESSID)
        Assert.assertSame(success, Unit)
    }


    /**
     * Checks month validator ERROR
     */
    @Test
    fun testMonthValidatorError() {
        try{
            Validator.validateMonth(0)
        } catch (e: Exception) {
            Assert.assertTrue(e is APIException)
        }
    }

    /**
     * Checks month validator success returns Unit
     */
    @Test
    fun testMonthValidatorSuccess() {
        val success = Validator.validateMonth(12)
        Assert.assertSame(success, Unit)
    }
}
