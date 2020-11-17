package io.github.arieldossantos.cuddlytrain.types

import java.sql.Timestamp

/**
 * Transaction type
 *
 * @param description
 * @param date
 * @param value
 */
class Transaction(val description: String, val date: Timestamp, val value: Int)
