package io.github.arieldossantos.cuddlytrain.util


/**
 * All functions of general purpose
 */
object General {
    /**
     * Get first digit of any int
     */
    fun getFirstDigit(x: Int): Int {
        var newX = x
        while (newX > 9) {
            newX /= 10
        }
        return newX
    }


    /**
     * Get last digit of any int
     */
    fun getLastDigit(x: Int): Int {
        return kotlin.math.abs(x) % 10
    }
}
