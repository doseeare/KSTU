import com.google.gson.annotations.SerializedName

data class PaymentDates (

	@SerializedName("PaymentDate") val paymentDate : String,
	@SerializedName("PaymentSum") val paymentSum : Int,
	@SerializedName("PaymentType") val paymentType : String,
	@SerializedName("PaymentGoal") val paymentGoal : String,
	@SerializedName("PaymentGroupName") val paymentGroupName : String
)