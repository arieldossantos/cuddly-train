package io.github.arieldossantos.cuddlytrain.util

import java.sql.Timestamp
import java.util.*
import kotlin.math.abs


/**
 * Generator functions for MOCK API
 */
object Generator {
    val CONSONANT = "BCDFGHJLMNPQRSTVWXZ "
    val VOWEL = "AEIOU"


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
    fun generateRandomTransactionValue(userId: Int, year: Int, transactionIndex: Int): Int {
        return if (transactionIndex % 2 == 0) {
            generateControlledRandomNumberWithDigits(
                General.getLastDigit(userId),
                General.getFirstDigit(year),
                transactionIndex
            )
        } else {
            generateControlledRandomNumberWithDigits(
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
        var day = generateControlledRandomNumberWithDigits(
            transactionIndex,
            General.getFirstDigit(userId)
        )
        day = if (day < 29) day else 1

        //generate hour
        var hourOfDay = generateControlledRandomNumberWithDigits(
            transactionIndex,
            General.getFirstDigit(userId)
        )
        hourOfDay = if (hourOfDay < 24) hourOfDay else 8

        //generate minutes
        var minutes = generateControlledRandomNumberWithDigits(
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
            generateControlledRandomNumberWithDigits(
                month,
                General.getLastDigit(userId) + 1
            )
        } else {
            generateControlledRandomNumberWithDigits(
                transactionIndex + 1,
                General.getFirstDigit(userId)
            )
        }
        val stringBuffer = StringBuffer()


        for (i in 0.. if(stringSize > 60 || stringSize < 10) 30 else stringSize) {
            val randomNumberForChar =
                generateControlledRandomNumberWithDigits(transactionIndex, i, General.getFirstDigit(userId))
            if (i % 2 == 0) {
                stringBuffer.append(CONSONANT[General.reduceNumberUntil(randomNumberForChar, 19)])
            } else {
                stringBuffer.append(VOWEL[General.reduceNumberUntil(randomNumberForChar, 4)])
            }
        }
        return if (stringBuffer.length % 2 == 0) stringBuffer.toString() else stringBuffer.substring(0, stringBuffer.length - 1)
    }

    /**
     * Generate a random number from the parameters
     *
     * @param digits array of digits
     */
    private fun generateControlledRandomNumberWithDigits(vararg digits: Int): Int {
        var controlledRandomResult = 0;
        for (i in digits.indices) {
            controlledRandomResult += if (i % 2 == 0) {
                digits[i] * 2
            } else {
                digits[i] / 2
            }
        }

        // return absolute number
        return abs(controlledRandomResult)
    }
}
