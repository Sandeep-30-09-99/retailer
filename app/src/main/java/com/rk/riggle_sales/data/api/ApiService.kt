package com.rk.riggle_sales.data.api

import com.rk.riggle_sales.data.model.User
import com.rk.riggle_sales.data.request.*
import com.rk.riggle_sales.data.response.*
import com.rk.riggle_sales.di.base.SimpleApiResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @Headers("Content-Type:application/json")
    @POST("delivery-hero/send/otp")
    suspend fun sendOtp(@Body request: SendRequest<SendOtpRequest>): Response<SimpleApiResponse<SendOtpResponse>>

    @Headers("Content-Type:application/json")
    @POST("delivery-hero/verify/otp")
    suspend fun verifyOtp(@Body request: SendRequest<VerifyOtpRequest>): Response<SimpleApiResponse<VerifyOtpResponse>>

    @Headers("Content-Type:application/json")
    @POST("delivery-hero/sign-up")
    suspend fun signupApi(@Body request: SendRequest<SignupRequest>): Response<SimpleApiResponse<SignupResponse>>

    @Headers("Content-Type:application/json")
    @POST("delivery-hero/update-profile")
    suspend fun updateProfile(
        @Header("Authorization") authorization: String,
        @Body request: SendRequest<UpdateProfileRequest>
    ): Response<SimpleApiResponse<ProfileData>>

    @Headers("Content-Type:application/json")
    @GET("delivery-hero/pending-order")
    suspend fun getPendingList(
        @Header("Authorization") authorization: String
    ): Response<SimpleApiResponse<List<PendingOrdersBean>>>

    @Headers("Content-Type:application/json")
    @GET("delivery-hero/order/list")
    suspend fun getProcessingList(
        @Header("Authorization") authorization: String,
        @Query("status") status: String
    ): Response<SimpleApiResponse<ProcessingOrdersBean>>

    @Headers("Content-Type:application/json")
    @PUT("delivery-hero/delivery-status")
    suspend fun updateStatus(
        @Header("Authorization") authorization: String,
        @Body request: SendRequest<UpdateStatus>
    ): Response<SimpleApiResponse<AcceptDeclineResponse>>

    @Headers("Content-Type:application/json")
    @POST("delivery-hero/update-location")
    suspend fun updateLocation(
        @Header("Authorization") authorization: String,
        @Body request: RequestBody
    ): Response<SimpleApiResponse<AcceptDeclineResponse>>

    @Headers("Content-Type:application/json")
    @GET("delivery-hero/get-profile")
    suspend fun getProfileData(
        @Header("Authorization") authorization: String
    ): Response<SimpleApiResponse<ProfileData>>

    @Headers("Content-Type:application/json")
    @POST("delivery-hero/status")
    suspend fun updateOnline(
        @Header("Authorization") authorization: String,
        @Body request: OnlineStatus
    ): Response<SimpleApiResponse<OnlineStatusData>>

    @Headers("Content-Type:application/json")
    @POST("delivery-hero/notify")
    suspend fun updateNotification(
        @Header("Authorization") authorization: String,
        @Body request: EnableNotification
    ): Response<SimpleApiResponse<ProfileData>>


    @Headers("Content-Type:application/json")
    @POST("delivery-hero/logout")
    suspend fun logOutApi(
        @Header("Authorization") authorization: String
    ): Response<SimpleApiResponse<LogoutResponse>>


    @Headers("Content-Type:application/json")
    @POST("upload/file")
    suspend fun uploadImage(
        @Body request: SendRequest<UploadRequest>
    ): Response<SimpleApiResponse<ImageUploadResponse>>


}