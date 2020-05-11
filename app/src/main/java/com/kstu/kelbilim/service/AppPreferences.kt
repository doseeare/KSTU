package com.kstu.kelbilim.service

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    private const val NAME = "Shelter"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isLogined: Boolean
        get() = preferences.getBoolean("isLogined", false)
        set(value) = preferences.edit {
            it.putBoolean("isLogined", value)
        }

    var token: String?
        get() = preferences.getString("token", "")
        set(value) = preferences.edit {
            it.putString("token", value)
        }

    var studentId: String?
        get() = preferences.getString("studentId", "")
        set(value) = preferences.edit {
            it.putString("studentId", value)
        }

    var studentName: String?
        get() = preferences.getString("studentName", "")
        set(value) = preferences.edit {
            it.putString("studentName", value)
        }

    var mobilePassword: String?
        get() = preferences.getString("mobilePassword", "")
        set(value) = preferences.edit {
            it.putString("mobilePassword", value)
        }
}