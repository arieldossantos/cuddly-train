package io.github.arieldossantos.cuddlytrain.controller

import io.github.arieldossantos.cuddlytrain.TransactionRequest
import io.github.arieldossantos.cuddlytrain.models.TransactionModel
import io.github.arieldossantos.cuddlytrain.util.Generator
import io.github.arieldossantos.cuddlytrain.util.Validator
import java.sql.Date
import java.sql.Timestamp

/**
 * Controller operator of any transaction request
 */
object TransactionController {
    fun returnUserTransactions(req: TransactionRequest): ArrayList<TransactionModel> {
        //Validate current id
        Validator.validateId(req.userId)
        val transactionList = ArrayList<TransactionModel>();
        val transactionLength = Generator.totalTransactionsInPeriod(req.userId, req.month)

        //For transaction generate
        for(i in 0 until transactionLength) {
            val currentTransaction = TransactionModel(
                "teste", //TODO legible description generation
                Date(2020, 10, 1), //TODO random date generate
                Generator.generateTransactionValue(
                    req.userId,
                    req.year,
                    i + 1
                )
            )
            //Add transaction to list
            transactionList.add(currentTransaction)
        }

        return transactionList
    }
}
