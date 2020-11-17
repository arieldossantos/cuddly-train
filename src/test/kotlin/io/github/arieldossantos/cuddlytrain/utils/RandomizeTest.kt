package io.github.arieldossantos.cuddlytrain.utils

import io.github.arieldossantos.cuddlytrain.utils.Randomize.generateControlledRandomNumberWithDigits
import org.junit.Test

import org.junit.Assert.*

class RandomizeTest {

    @Test
    fun testGenerateControlledRandomNumberWithDigits() {
        assertSame(generateControlledRandomNumberWithDigits(4, 2), 9)
        assertSame(generateControlledRandomNumberWithDigits(5, 1), 10)
    }
}
