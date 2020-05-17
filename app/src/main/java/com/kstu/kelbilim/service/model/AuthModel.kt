package com.kstu.kelbilim.service.model

import com.google.gson.annotations.SerializedName

data class AuthModel(
    @SerializedName("Login") val login: String,
    @SerializedName("Password") val password: String
)