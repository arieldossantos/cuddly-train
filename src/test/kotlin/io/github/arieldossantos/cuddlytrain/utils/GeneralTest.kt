package io.github.arieldossantos.cuddlytrain.utils

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

    @Test
    fun testGetLastDigit() {
        Assert.assertSame(General.getLastDigit(106), 6)
        Assert.assertSame(General.getLastDigit(90000), 0)
        Assert.assertSame(General.getLastDigit(5002), 2)
    }


    @Test
    fun testReduceNumberUntil() {
        Assert.assertSame(General.reduceNumberUntil(19, 19), 19)
        Assert.assertSame(General.reduceNumberUntil(19, 18), 9)
        Assert.assertSame(General.reduceNumberUntil(26, 5), 4)
    }
}
