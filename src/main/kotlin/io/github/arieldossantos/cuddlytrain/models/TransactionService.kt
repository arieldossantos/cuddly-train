package io.github.arieldossantos.cuddlytrain.models

import io.github.arieldossantos.cuddlytrain.types.Transaction
import io.github.arieldossantos.cuddlytrain.utils.General

object TransactionService {
    fun run(userId: Int, month: Int, year: Int): ArrayList<Transaction> {
        val transactionList = ArrayList<Transaction>();
        val transactionLength = this.totalTransactionsInPeriod(userId, month)

        //For transaction generate
        for(i in 1..transactionLength) {
            //New transaction
            val currentTransaction = TransactionModel(userId, month, year, i)
            //Add transaction to list
            transactionList.add(currentTransaction.createTransaction())
        }

        return transactionList
    }


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
