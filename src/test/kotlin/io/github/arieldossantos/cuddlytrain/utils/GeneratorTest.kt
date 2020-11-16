package io.github.arieldossantos.cuddlytrain.utils

import org.junit.Assert
import org.junit.Test

class GeneratorTest {
    /**
     * Test total transactions in period
     */
    @Test
    fun testTotalTransactionsInPeriod() {
        Assert.assertSame(Generator.totalTransactionsInPeriod(12243, 1), 1)
        Assert.assertSame(Generator.totalTransactionsInPeriod(3423, 3), 9)
        Assert.assertSame(Generator.totalTransactionsInPeriod(723, 12), 84)
    }

    /**
     * Test generation of transaction value
     */
    @Test
    fun testGenerateTransactionValue() {
        Assert.assertSame(Generator.generateRandomTransactionValue(12243, 2020, 1), 4)
        Assert.assertSame(Generator.generateRandomTransactionValue(3423, 2019, 12), 31)
        Assert.assertSame(Generator.generateRandomTransactionValue(723, 1997, 5), 27)
    }
}
