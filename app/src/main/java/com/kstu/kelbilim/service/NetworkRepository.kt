package com.kstu.kelbilim.service

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

    fun hotels() = liveData(Dispatchers.IO) {
        try {
            val response = RetrofitClient.apiService().hotels()
            when {
                response.isSuccessful -> {
                    if (response.body() != null) {
                        emit(Resource.success(response.body()))
                    } else {
                        emit(Resource.error("Не найдено", emptyList()))
                    }
                }
                else -> {
                    emit(Resource.error("Не найдено", emptyList()))
                }
            }
        } catch (e: Exception) {
            emit(Resource.netwrok("Проблемы с подключением интернета", null))
        }

    }
*/

}