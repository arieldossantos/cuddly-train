package io.github.arieldossantos.cuddlytrain.utils

import kotlin.math.abs


/**
 * All functions of general purpose
 */
object General {
    /**
     * Get first digit of any int
     *
     * @param x any int
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
     *
     * @param x any int
     */
    fun getLastDigit(x: Int): Int {
        return abs(x) % 10
    }


    /**
     * Reduce first number
     *
     * @param x any int
     * @param maxNumber max number
     */
    fun reduceNumberUntil(x: Int, maxNumber: Int): Int {
        var newX = x
        while (newX > maxNumber) {
            newX -= 10
        }

        //return absolute number checking maxnumber again
        return if(abs(newX) > maxNumber) maxNumber - 1 else abs(newX)
    }
}
