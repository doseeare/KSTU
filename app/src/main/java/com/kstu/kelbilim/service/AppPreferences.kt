package com.timelysoft.shelter.service

import android.content.Context
import android.content.SharedPreferences
import com.timelysoft.shelter.extension.timeToLong

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

    fun clear() {
        isLogined = false
        token = ""
        refreshToken = ""
        login = ""
        tokenRefreshTime = 1000L
    }

    fun update(tokenResponse: TokenResponse) {
        token = tokenResponse.accessToken
        refreshToken = tokenResponse.refreshToken
        tokenRefreshTime = tokenResponse.expiresUtc.timeToLong()

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
    var login: String?
        get() = preferences.getString("login", "")
        set(value) = preferences.edit {
            it.putString("login", value)
        }

    var started: Boolean
        get() = preferences.getBoolean("started", false)
        set(value) = preferences.edit() {
            it.putBoolean("started", value)
        }

    var refreshToken: String?
        get() = preferences.getString("refreshToken", "")
        set(value) = preferences.edit {
            it.putString("refreshToken", value)
        }

    var fullName: String?
        get() = preferences.getString("fullName", "")
        set(value) = preferences.edit {
            it.putString("fullName", value)
        }

    var hotelIdent: String?
        get() = preferences.getString("hotelIdent", "")
        set(value) = preferences.edit {
            it.putString("hotelIdent", value)
        }

    var tokenRefreshTime: Long
        get() = preferences.getLong("tokenRefreshTime", 1000)
        set(value) = preferences.edit {
            it.putLong("tokenRefreshTime", value)
        }
}