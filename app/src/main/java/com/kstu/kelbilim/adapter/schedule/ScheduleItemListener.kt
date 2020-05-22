package com.kstu.kelbilim.adapter.schedule

import com.kstu.kelbilim.service.response.schedule.ScheduleDiciples

interface ScheduleItemListener {
    fun scheduleItemClicked(model: ScheduleDiciples)
}