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


    /**
     * Generate a random transaction value
     *
     * @param id user id
     * @param year current year
     */
    fun generateTransactionValue(id: Int, year: Int, transactionIndex: Int): Int {
        return General.getFirstDigit(id) * General.getFirstDigit(year) * transactionIndex;
    }
}
