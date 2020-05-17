package com.kstu.kelbilim.service.response.studycard

import com.google.gson.annotations.SerializedName

data class StudyCardResponse(
    @SerializedName("StudentID") val studentID: Int,
    @SerializedName("FullName") val fullName: String,
    @SerializedName("GroupID") val groupID: Int,
    @SerializedName("GroupName") val groupName: String,
    @SerializedName("Cemesters") val cemesters: List<CardCemesters>
)