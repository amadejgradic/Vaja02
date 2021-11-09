package com.example.mylib

import kotlin.random.Random

class Date(var day: Int = 0, var month: Int = 0, var year: Int = 0) : Comparable<Date> {
    override fun toString() = when {

        day < 10 && month < 10 -> "0$day-0$month-$year"
        day > 10 && month < 10 -> "$day-0$month-$year"
        day < 10 && month > 10 -> "0$day-$month-$year"
        else -> "$day-$month-$year"

    }

    override fun compareTo(other: Date) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> day - other.day
    }

    fun toDate(date: String): Date {
        val dateStr = date.trimStart('0')
        val day = dateStr.substringBefore('-').trimStart('0').toInt()
        val month = dateStr.substringAfter('-').substringBefore('-').trimStart('0').toInt()
        val year = dateStr.substringAfterLast('-').toInt()

        if (!(day in 1..30 && month in 1..12 && year in 1900..2100)) throw invalidDateConversion(
            "datum ni v mejah"
        )
        return Date(day, month, year)


    }

    fun makeRandomDate(from: Int, to: Int): Date {
        var isLeap = false
        val randYear = Random.nextInt(from, to)
        if (randYear % 4 == 0 && randYear % 100 == 0 && randYear % 400 == 0) {
            isLeap = true
        }
        year = randYear
        month = Random.nextInt(1, 12)
        if (month == 2) {
            day = Random.nextInt(1, 28)
            if (isLeap) day = Random.nextInt(1, 29)
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = Random.nextInt(1, 30)
        } else day = Random.nextInt(1, 31)
        return Date(day, month, year)
    }
}