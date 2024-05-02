package com.aait.coreui.util

import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(): String {
    val cal = Calendar.getInstance(Locale.ENGLISH)
    val month = cal[Calendar.MONTH] + 1
    val day = cal[Calendar.DAY_OF_MONTH]

    var dayC = day.toString()
    if (dayC.length == 1) {
        dayC = "0$dayC"
    }
    var monthC = month.toString()
    if (monthC.length == 1) {
        monthC = "0$monthC"
    }
    val yearC = cal[Calendar.YEAR]

    return "$dayC-$monthC-$yearC"
}

fun getCurrentTime(): String {
    val currentTime: Date = Calendar.getInstance(Locale.ENGLISH).time

    val inFormat: SimpleDateFormat?
    val parse2: Date?

    inFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH)
    val dateText = inFormat.format(currentTime)
    parse2 = inFormat.parse(dateText)

    var hour = DateFormat.format("HH", parse2).toString()
    val minute = DateFormat.format("mm", parse2).toString()
    var timeType = "AM"
    if (hour.toInt() > 12) {
        hour = "${hour.toInt() - 12}"
        timeType = "PM"
    }

    return "$hour:$minute $timeType"
}