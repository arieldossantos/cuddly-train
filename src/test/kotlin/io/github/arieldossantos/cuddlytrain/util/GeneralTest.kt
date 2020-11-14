package io.github.arieldossantos.cuddlytrain.util

import org.junit.Assert
import org.junit.Test

class GeneralTest {
    /**
     * Test first digit of const passed
     */
    @Test
    fun testGetFirstDigit() {
        Assert.assertSame(General.getFirstDigit(100), 1)
        Assert.assertSame(General.getFirstDigit(90000), 9)
        Assert.assertSame(General.getFirstDigit(5000), 5)
    }
}
