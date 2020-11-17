package io.github.arieldossantos.cuddlytrain.models

import org.junit.Test

import org.junit.Assert.*

class TransactionServiceTest {

    @Test
    fun testRun() {
        val returnedList = TransactionService.run(1234, 1,2020)
        assertSame(returnedList.size, 1)
        assertSame(returnedList[0].value, 4)
    }

    @Test
    fun testTotalTransactionsInPeriod() {
        assertSame(TransactionService.totalTransactionsInPeriod(1234, 5), 5)
        assertSame(TransactionService.totalTransactionsInPeriod(2234, 5), 10)
    }
}
