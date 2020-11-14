package io.github.arieldossantos.cuddlytrain.models

import java.util.*

/**
 * Transaction model
 *
 * @param descricao Descrição da transação
 * @param data Data da transação
 * @param valor Valor da transação
 */
class TransactionModel(val descricao: String, val data: Date, val valor: Int)
