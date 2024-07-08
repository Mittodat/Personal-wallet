package com.dd.personalwallet.utils

import java.util.*

object DateTimeUtils {

    fun getCurrentDate(): List<Int> {
        val calendar = Calendar.getInstance()
        val date = calendar[Calendar.DATE]
        val month = calendar[Calendar.MONTH] + 1
        val year = calendar[Calendar.YEAR]
        return listOf(date, month, year)
    }
}