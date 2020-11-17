package io.github.arieldossantos.cuddlytrain.utils

import java.sql.Timestamp
import java.util.*
import kotlin.math.abs


/**
 * Generator functions for MOCK API
 */
object Randomize {
    /**
     * Generate a random number from the parameters
     *
     * @param digits array of digits
     */
    fun generateControlledRandomNumberWithDigits(vararg digits: Int): Int {
        var controlledRandomResult = 0;
        for (i in digits.indices) {
            controlledRandomResult += if (i % 2 == 0) {
                digits[i] * 2
            } else {
                digits[i] / 2
            }
        }

        // return absolute number
        return abs(controlledRandomResult)
    }
}
