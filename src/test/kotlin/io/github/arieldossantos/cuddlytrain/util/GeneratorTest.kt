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
}
