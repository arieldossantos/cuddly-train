package io.github.arieldossantos.cuddlytrain.controller

import io.github.arieldossantos.cuddlytrain.Transaction
import io.github.arieldossantos.cuddlytrain.util.Validator


object TransactionController {
    fun returnUserTransactions(transaction: Transaction): String {
        Validator.validateId(transaction.id)
        return "{}"
    }
}
