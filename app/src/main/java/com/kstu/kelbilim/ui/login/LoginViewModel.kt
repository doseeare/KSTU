package com.kstu.kelbilim.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kstu.kelbilim.service.NetworkRepository
import com.kstu.kelbilim.service.Resource
import com.kstu.kelbilim.service.model.AuthModel
import com.kstu.kelbilim.service.response.AuthResponse


class LoginViewModel : ViewModel() {

    private val repository = NetworkRepository()

    fun login (headerMap: HashMap <String, String>, login : String, password : String) : LiveData <Resource<AuthResponse>>{
        return repository.login(headerMap, AuthModel(login, password))
    }

}