package io.github.arieldossantos.cuddlytrain.util

/**
 * All functions of general purpose
 */
object General {
    /**
     * Get first digit of any int number
     */
    fun getFirstDigit(x: Int): Int {
        var newX = x
        while (newX > 9) {
            newX /= 10
        }
        return newX
    }
}
