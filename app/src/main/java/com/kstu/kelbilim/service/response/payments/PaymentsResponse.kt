package com.kstu.kelbilim.service.response.payments

import PaymentDates
import Payments
import com.google.gson.annotations.SerializedName

data class PaymentsResponse (
	@SerializedName("StudentID") val studentID : Int,
	@SerializedName("FullName") val fullName : String,
	@SerializedName("GroupID") val groupID : Int,
	@SerializedName("GroupName") val groupName : String,
	@SerializedName("Dolg") val dolg : Double,
	@SerializedName("Account") val account : String,
	@SerializedName("Payments") val payments : ArrayList<Payments>,
	@SerializedName("PaymentDates") val paymentDates : List<PaymentDates>
)
