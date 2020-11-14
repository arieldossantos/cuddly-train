package io.github.arieldossantos.cuddlytrain.util

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
        Assert.assertSame(Generator.generateTransactionValue(12243, 2020, 1), 2)
        Assert.assertSame(Generator.generateTransactionValue(3423, 2019, 12), 72)
        Assert.assertSame(Generator.generateTransactionValue(723, 1997, 5), 35)
    }
}
