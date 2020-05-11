package com.kstu.kelbilim.service

import com.kstu.kelbilim.service.model.AuthModel
import com.kstu.kelbilim.service.model.UserInfoModel
import com.kstu.kelbilim.service.response.AuthResponse
import com.kstu.kelbilim.service.response.schedule.ScheduleResponse
import retrofit2.Response
import retrofit2.http.*


interface ApiService {
/*

    @POST("Accounts/login")
    suspend fun login(@Body model: AuthModel): Response<TokenResponse>

    @POST("Accounts/refresh")
    suspend fun refreshToken(@Query("refreshToken") refreshToken: String): Response<TokenResponse>

    @GET("Hotels/GetManagersHotels")
    suspend fun hotels(): Response<List<HotelResponse>>

    @GET("Apartments")
    suspend fun apartments(@QueryMap options: Map<String, String>): Response<CommonModelPagination<ApartmentsResponse>>

    @GET("Apartments/GetApartmentTypes")
    suspend fun apartmentsType(@Query("HotelIdent") hotelIdent: String): Response<List<ApartmentTypeResponse>>

    @GET("Profile")
    suspend fun profile(): Response<ProfileResponse>

    @GET("Apartments/{id}")
    suspend fun apartmentsDetail(@Path("id") id: Int, @Query("HotelIdent") hotelIdent: String): Response<ApartmentsDetailResponse>
}*/

    @POST("studyschedule")
    suspend fun getSchedule(@HeaderMap headers: Map<String, String>, @Body body: UserInfoModel): Response<ScheduleResponse>

    @POST("authen")
    suspend fun login(@HeaderMap headers: Map<String, String>, @Body body: AuthModel): Response<AuthResponse>

}