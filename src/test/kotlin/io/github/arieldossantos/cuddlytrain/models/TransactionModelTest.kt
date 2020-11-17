package io.github.arieldossantos.cuddlytrain.models

import io.github.arieldossantos.cuddlytrain.types.Transaction
import org.junit.Test

import org.junit.Assert.*

class TransactionModelTest {
    val transactionOdd = TransactionModel(1234, 10, 2020, 1).createTransaction()
    val transactionEven = TransactionModel(1234, 10, 2020, 2).createTransaction()



    @Test
    fun testGetTransaction() {
        assert(transactionOdd is Transaction)
        assert(transactionEven is Transaction)
    }

    @Test
    fun generateRandomTransactionValue() {
        assertSame(
            transactionOdd.value, 4
        )
        assertSame(
            transactionEven.value, 13
        )
    }

    @Test
    fun generateRandomDate() {
        assertSame(
            transactionOdd.date.month, 9
        )
        assertSame(
            transactionOdd.date.day, 5
        )
        assertSame(
            transactionOdd.date.toLocalDateTime().year, 2020
        )
        assertSame(
            transactionEven.date.month, 9
        )
        assertSame(
            transactionEven.date.day, 1
        )
        assertSame(
            transactionEven.date.toLocalDateTime().year, 2020
        )
    }

    @Test
    fun generateRandomDescription() {
        assertEquals(
            transactionOdd.description.toLowerCase(), "GUHOJULOMINEPAQERISOTUVOWUXOZI".toLowerCase()
        )
        assertEquals(
            transactionEven.description.toLowerCase(), "JULOMINEPAQERISOTUVOWU".toLowerCase()
        )
    }
}
