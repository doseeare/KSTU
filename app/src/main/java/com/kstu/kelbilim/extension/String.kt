package com.kstu.kelbilim.extension

import java.text.SimpleDateFormat

fun String.day(): String {
    return try {
        this.substring(8, 10)
    } catch (e: Exception) {
        ""
    }
}

fun String.month(): String {
    return try {
        return when (this.substring(5, 7).toInt()) {
            1 -> "Jan"
            2 -> "Feb"
            3 -> "Mar"
            4 -> "Apr"
            5 -> "May"
            6 -> "Jun"
            7 -> "Jul"
            8 -> "Aug"
            9 -> "Sept"
            10 -> "Oct"
            11 -> "Nov"
            12 -> "Dec"
            else -> ""
        }
    } catch (e: Exception) {
        ""
    }
}

fun String.timeToLong(): Long {
    return try {
        val time = this.replace("T"," ").substring(0,16)
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
        format.parse(time).time
    }catch (e:Exception){
         0
    }
}