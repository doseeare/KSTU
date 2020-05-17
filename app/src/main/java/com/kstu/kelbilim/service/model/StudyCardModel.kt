package com.kstu.kelbilim.service.model

import com.google.gson.annotations.SerializedName

data class StudyCardModel(
    @SerializedName("StudentID") val studentID: Int,
    @SerializedName("CemesterID") val cemesterID: Int,
    @SerializedName("authen") val authen: Authen
)