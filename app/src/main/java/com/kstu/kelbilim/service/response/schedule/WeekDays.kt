package com.kstu.kelbilim.service.response.schedule

import com.google.gson.annotations.SerializedName
import com.kstu.kelbilim.service.response.schedule.ScheduleDiciples

data class WeekDays (
	@SerializedName("WeekDayID") val weekDayID : Int,
	@SerializedName("WeekDayName") val weekDayName : String,
	@SerializedName("WeekDayShortName") val weekDayShortName : String,
	@SerializedName("ScheduleDiciples") val scheduleDiciples : List<ScheduleDiciples>
)