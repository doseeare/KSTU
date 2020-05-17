package com.kstu.kelbilim.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kstu.kelbilim.service.NetworkRepository
import com.kstu.kelbilim.service.Resource
import com.kstu.kelbilim.service.model.UserInfoModel
import com.kstu.kelbilim.service.response.payments.PaymentsResponse

class ProfileViewModel : ViewModel() {
    private val repository = NetworkRepository()

    fun getPayments (headerMap: HashMap <String, String>, body: UserInfoModel) : LiveData<Resource<PaymentsResponse>> {
        return repository.getPayments(headerMap, body)
    }

}