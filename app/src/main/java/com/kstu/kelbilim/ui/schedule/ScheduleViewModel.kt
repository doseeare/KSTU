package com.kstu.kelbilim.ui.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kstu.kelbilim.service.NetworkRepository
import com.kstu.kelbilim.service.Resource
import com.kstu.kelbilim.service.model.UserInfoModel
import com.kstu.kelbilim.service.response.schedule.ScheduleResponse

class ScheduleViewModel : ViewModel() {
    private val repository = NetworkRepository()

    fun getSchedule (headerMap: HashMap <String, String>, body: UserInfoModel) : LiveData <Resource<ScheduleResponse>>{
        return repository.getSchedule(headerMap, body)
    }

}