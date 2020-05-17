package com.kstu.kelbilim.extension

fun Int.toRoom(): String {
    val a = this
    return when (this) {
        1 -> "Одноместный номер"
        2 -> "Двухместный номер"
        3 -> "Трехместный номер"
        4 -> "Четырехместный номер"
        else -> ""
    }
}