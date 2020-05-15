package com.kstu.kelbilim.service

import androidx.lifecycle.liveData
import com.kstu.kelbilim.service.model.AuthModel
import com.kstu.kelbilim.service.model.UserInfoModel
import kotlinx.coroutines.Dispatchers

class NetworkRepository {
    /*

        fun login(model: AuthModel) = liveData(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService().login(model)
                when {
                    response.isSuccessful -> {
                        emit(Resource.success(response.body()))
                    }
                    else -> {
                        emit(Resource.error("Пользователь не найден"))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.netwrok("Проблеммы с подключение интернета", null))
            }

        }
    */
    fun login(headers: HashMap<String, String>, body: AuthModel) = liveData(Dispatchers.IO) {
        try {
            val response = AvnRetrofitClient.apiService().login(headers, body)
            when {
                response.isSuccessful -> {
                    if (response.body() != null) {
                        emit(Resource.success(response.body()))
                    } else {
                        emit(Resource.error("Не найдено"))
                    }
                }
                else -> {
                    emit(Resource.error("Не найдено"))
                }
            }
        } catch (e: Exception) {
            emit(Resource.network("Проблеммы с подключением интернета", null))
        }
    }

    fun getSchedule(headers: HashMap<String, String>, body: UserInfoModel) = liveData(Dispatchers.IO) {
        try {
            val response = AvnRetrofitClient.apiService().getSchedule(headers, body)
            val code = response.code()
            when {
                response.isSuccessful -> {
                    if (response.body() != null) {
                        emit(Resource.success(response.body()))
                    } else {
                        emit(Resource.error("Не найдено"))
                    }
                }
                else -> {
                    emit(Resource.error("Не найдено"))
                }
            }
        } catch (e: Exception) {
            emit(Resource.network("Проблемы с подключением интернета", null))
        }
    }
    fun getPayments(headers: HashMap<String, String>, body: UserInfoModel) = liveData(Dispatchers.IO) {
        try {
            val response = AvnRetrofitClient.apiService().getPayments(headers, body)
            val code = response.code()
            when {
                response.isSuccessful -> {
                    if (response.body() != null) {
                        emit(Resource.success(response.body()))
                    } else {
                        emit(Resource.error("Не найдено"))
                    }
                }
                else -> {
                    emit(Resource.error("Не найдено"))
                }
            }
        } catch (e: Exception) {
            emit(Resource.network("Проблемы с подключением интернета", null))
        }
    }

}