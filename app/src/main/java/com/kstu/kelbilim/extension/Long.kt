package com.kstu.kelbilim.extension

import java.text.SimpleDateFormat
import java.util.*

fun Long.toServerDate(): String {
    try {
        val date = Date(this)
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return format.format(date).replace(" ", "T")
    } catch (e: Exception) {
        return ""
    }

}
