package com.kstu.kelbilim.service.response.studycard

import com.google.gson.annotations.SerializedName


data class CardDiciplines (
    @SerializedName("ID") val iD : Int,
    @SerializedName("Name") val name : String,
    @SerializedName("Credit") val credit : Int,
    @SerializedName("Ball") val ball : Int,
    @SerializedName("EstimationID") val estimationID : Int,
    @SerializedName("EstimationName") val estimationName : String,
    @SerializedName("DeliveryDate") val deliveryDate : String
)