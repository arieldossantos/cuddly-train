package io.github.arieldossantos.cuddlytrain.controllers.transactions

import io.github.arieldossantos.cuddlytrain.controllers.transactions.TransactionValidator
import io.github.arieldossantos.cuddlytrain.controllers.exceptions.APIException
import org.junit.Assert
import org.junit.Test


class TransactionValidatorTest {
    private val ERRORID = 123
    private val SUCCESSID = 1234
    /**
     * Checks id validator ERROR
     */
    @Test
    fun testIdValidatorError() {
        try{
            TransactionValidator.validateId(ERRORID)
        } catch (e: Exception) {
            Assert.assertTrue(e is APIException)
        }
    }

    /**
     * Checks id validator success returns Unit
     */
    @Test
    fun testIdValidatorSuccess() {
        val success = TransactionValidator.validateId(SUCCESSID)
        Assert.assertSame(success, Unit)
    }


    /**
     * Checks month validator ERROR
     */
    @Test
    fun testMonthValidatorError() {
        try{
            TransactionValidator.validateMonth(0)
        } catch (e: Exception) {
            Assert.assertTrue(e is APIException)
        }
    }

    /**
     * Checks month validator success returns Unit
     */
    @Test
    fun testMonthValidatorSuccess() {
        val success = TransactionValidator.validateMonth(12)
        Assert.assertSame(success, Unit)
    }
}
