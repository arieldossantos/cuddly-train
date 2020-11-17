package io.github.arieldossantos.cuddlytrain.types

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

/**
 * Transaction type
 *
 * @param description transaction description
 * @param date date in timestamp
 * @param value transaction value
 */
class Transaction(
    @JsonProperty("descricao")         val description: String,
    @JsonProperty("data")              val date: Timestamp,
    @JsonProperty("valor")             val value: Int)
