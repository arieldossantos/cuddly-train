package io.github.arieldossantos.cuddlytrain.util


/**
 * Generator functions for MOCK API
 */
object Generator {
    /**
     * Get total transactions of a month period
     *
     * @param id user id
     * @param month month int representative
     */
    fun totalTransactionsInPeriod(id: Int, month: Int): Int {
        return General.getFirstDigit(id) * month
    }
}
