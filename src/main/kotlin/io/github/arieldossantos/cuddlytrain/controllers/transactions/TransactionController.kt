package io.github.arieldossantos.cuddlytrain.controllers.transactions

import io.github.arieldossantos.cuddlytrain.TransactionRequest
import io.github.arieldossantos.cuddlytrain.models.TransactionModel
import io.github.arieldossantos.cuddlytrain.models.TransactionService
import io.github.arieldossantos.cuddlytrain.types.Transaction
import io.github.arieldossantos.cuddlytrain.utils.Randomize

/**
 * Controller operator of any transaction request
 */
object TransactionController {
    fun returnUserTransactions(req: TransactionRequest): ArrayList<Transaction> {
        //Validations
        TransactionValidator.validateId(req.userId)
        TransactionValidator.validateMonth(req.month)

        return TransactionService.run(req.userId, req.month, req.year)
    }
}
