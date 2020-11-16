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
        //Validations
        Validator.validateId(req.userId)
        Validator.validateMonth(req.month)

        val transactionList = ArrayList<TransactionModel>();
        val transactionLength = Generator.totalTransactionsInPeriod(req.userId, req.month)

        //For transaction generate
        for(i in 0 until transactionLength) {
            val transactionDate         = Generator.generateRandomDate(req.userId, req.month, req.year, i + 1)
            val transactionValue        = Generator.generateRandomTransactionValue(req.userId, req.year, i + 1)
            val transactionDescription  = Generator.generateRandomDescription(req.userId, req.month, i + 1).toLowerCase()

            //New transaction
            val currentTransaction = TransactionModel(
                transactionDescription,
                transactionDate,
                transactionValue
            )
            //Add transaction to list
            transactionList.add(currentTransaction)
        }

        return transactionList
    }
}
