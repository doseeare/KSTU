package com.kstu.kelbilim.service


data class Resource<out T>(val status: Status, val data: T?, val msg: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String = "", data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

//        fun <T> refreshToken(msg: String = "", data: T? = null): Resource<T> {
//            return Resource(Status.REFRESHTOKEN, data, msg)
//        }
        fun <T> network(msg: String = "", data: T? = null): Resource<T> {
            return Resource(Status.NETWORK, data, msg)
        }
//
//        fun <T> loading(msg: String = ""): Resource<T> {
//            return Resource(Status.LOADING, null, msg)
//        }
//
//        fun <T> token(msg: String = ""): Resource<T> {
//            return Resource(Status.TOKEN, null, msg)
//        }


    }
}

enum class Status {
    SUCCESS,
    ERROR,
    REFRESHTOKEN,
    NETWORK

//    LOADING,
//    TOKEN,

}
