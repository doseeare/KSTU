package com.kstu.kelbilim.service.response.schedule

import com.google.gson.annotations.SerializedName

data class ScheduleDiciples (

    @SerializedName("ID") val iD : Int,
    @SerializedName("Name") val name : String,
    @SerializedName("TimeID") val timeID : Int,
    @SerializedName("Time") val time : String,
    @SerializedName("StudyTypeID") val studyTypeID : Int,
    @SerializedName("StudyTypeName") val studyTypeName : String,
    @SerializedName("TeacherID") val teacherID : Int,
    @SerializedName("TeacherName") val teacherName : String,
    @SerializedName("AuditoriaNumber") val auditoriaNumber : String,
    @SerializedName("EveryWeek") val everyWeek : Int
)