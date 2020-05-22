import com.google.gson.annotations.SerializedName

data class Payments (

	@SerializedName("StudyYear") val studyYear : String,
	@SerializedName("Kurs") val kurs : String,
	@SerializedName("GroupName") val groupName : String,
	@SerializedName("Contract") val contract : Double,
	@SerializedName("Paid") val paid : Double,
	@SerializedName("Dolg") val dolg : Double
)