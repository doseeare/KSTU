package com.kstu.kelbilim.service.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("IdStudent") val idStudent: Int,
    @SerializedName("StudentName") val studentName: String,
    @SerializedName("MobileLogin") val mobileLogin: String,
    @SerializedName("MobilePassword") val mobilePassword: String,
    @SerializedName("FlagForMobile") val flagForMobile: Int
)