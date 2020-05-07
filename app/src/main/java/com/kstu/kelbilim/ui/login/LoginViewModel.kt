package com.timelysoft.shelter.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.timelysoft.shelter.extension.timeToLong
import com.timelysoft.shelter.service.AppPreferences
import com.timelysoft.shelter.service.NetworkRepository
import com.timelysoft.shelter.service.Resource
import com.timelysoft.shelter.service.request.AuthModel
import com.timelysoft.shelter.service.response.TokenResponse


class LoginViewModel : ViewModel() {
    private val repository = NetworkRepository()

    fun login(login: String, password: String): LiveData<Resource<TokenResponse>> {
        return repository.login(AuthModel(login, password))
    }

    fun saveToken(token: TokenResponse, login: String) {
        AppPreferences.isLogined = true
        AppPreferences.login = login
        AppPreferences.token = token.accessToken
        AppPreferences.refreshToken = token.refreshToken
        AppPreferences.tokenRefreshTime = token.expiresUtc.timeToLong()
        AppPreferences.fullName = token.fullName
    }

}