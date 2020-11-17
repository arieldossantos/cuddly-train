package io.github.arieldossantos.cuddlytrain.models

import io.github.arieldossantos.cuddlytrain.types.Transaction
import io.github.arieldossantos.cuddlytrain.utils.General
import io.github.arieldossantos.cuddlytrain.utils.Randomize
import java.sql.Timestamp
import java.util.*

/**
 * Transaction model
 *
 * @param descricao Descrição da transação
 * @param data Data da transação
 * @param valor Valor da transação
 */
class TransactionModel {
    private val CONSONANT = "BCDFGHJLMNPQRSTVWXZ "
    private val VOWEL = "AEIOU"
    val transaction: Transaction

    constructor(userId: Int, month: Int, year: Int, transactionIndex: Int) {
        val transactionDate         = this.generateRandomDate(userId, month, year, transactionIndex)
        val transactionValue        = this.generateRandomTransactionValue(userId, year, transactionIndex)
        val transactionDescription  = this.generateRandomDescription(userId, month, transactionIndex).toLowerCase()
        this.transaction = Transaction(transactionDescription, transactionDate, transactionValue)
    }

    /**
     * Generate a random transaction value
     *
     * @param id user id
     * @param year current year
     */
    fun generateRandomTransactionValue(userId: Int, year: Int, transactionIndex: Int): Int {
        return if (transactionIndex % 2 == 0) {
            Randomize.generateControlledRandomNumberWithDigits(
                General.getLastDigit(userId),
                General.getFirstDigit(year),
                transactionIndex
            )
        } else {
            Randomize.generateControlledRandomNumberWithDigits(
                General.getFirstDigit(userId),
                General.getLastDigit(year),
                transactionIndex
            )
        }
    }

    /**
     * Generate a controlled random Date with params
     *
     * @param transactionIndex transaction index
     * @param userId user id
     * @param month date month
     * @param year date year
     */
    fun generateRandomDate(userId: Int, month: Int, year: Int, transactionIndex: Int): Timestamp {
        //generate day
        var day = Randomize.generateControlledRandomNumberWithDigits(
            transactionIndex,
            General.getFirstDigit(userId)
        )
        day = if (day < 29) day else 1

        //generate hour
        var hourOfDay = Randomize.generateControlledRandomNumberWithDigits(
            transactionIndex,
            General.getFirstDigit(userId)
        )
        hourOfDay = if (hourOfDay < 24) hourOfDay else 8

        //generate minutes
        var minutes = Randomize.generateControlledRandomNumberWithDigits(
            transactionIndex,
            General.getFirstDigit(userId)
        )
        minutes = if (minutes < 60) minutes else 0


        //Generate new gregorian calendar
        val newCal = GregorianCalendar(
            year,
            month - 1,
            day,
            hourOfDay,
            minutes
        )

        return Timestamp.from(newCal.toInstant())
    }


    /**
     * Generate random legible description
     *
     * @param userId user id requested
     * @param month month number
     * @param transactionIndex transaction index
     */
    fun generateRandomDescription(userId: Int, month: Int, transactionIndex: Int): String {
        val stringSize = if (transactionIndex % 2 == 0) {
            Randomize.generateControlledRandomNumberWithDigits(
                month,
                General.getLastDigit(userId) + 1
            )
        } else {
            Randomize.generateControlledRandomNumberWithDigits(
                transactionIndex + 1,
                General.getFirstDigit(userId)
            )
        }
        val stringBuffer = StringBuffer()


        for (i in 0.. if(stringSize > 60 || stringSize < 10) 30 else stringSize) {
            val randomNumberForChar =
                Randomize.generateControlledRandomNumberWithDigits(transactionIndex, i, General.getFirstDigit(userId))
            if (i % 2 == 0) {
                stringBuffer.append(CONSONANT[General.reduceNumberUntil(randomNumberForChar, 19)])
            } else {
                stringBuffer.append(VOWEL[General.reduceNumberUntil(randomNumberForChar, 4)])
            }
        }
        return if (stringBuffer.length % 2 == 0) stringBuffer.toString() else stringBuffer.substring(0, stringBuffer.length - 1)
    }
}
