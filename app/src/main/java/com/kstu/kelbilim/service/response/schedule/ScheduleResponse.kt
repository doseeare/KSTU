package com.kstu.kelbilim.service.response.schedule

import com.google.gson.annotations.SerializedName
import com.kstu.kelbilim.service.response.schedule.WeekDays

data class ScheduleResponse (
    @SerializedName("StudentID") val studentID : Int,
    @SerializedName("FullName") val fullName : String,
    @SerializedName("GroupID") val groupID : Int,
    @SerializedName("GroupName") val groupName : String,
    @SerializedName("CemesterID") val cemesterID : Int,
    @SerializedName("CemesterName") val cemesterName : String,
    @SerializedName("com.kstu.kelbilim.service.response.schedule.WeekDays") val weekDays : List<WeekDays>
)