package com.rk.riggle_sales.data.api

import com.rk.riggle_sales.data.model.User
import com.rk.riggle_sales.data.request.*
import com.rk.riggle_sales.data.response.*
import com.rk.riggle_sales.di.base.SimpleApiResponse
import okhttp3.RequestBody
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>

    suspend fun sendOtp(request: SendRequest<SendOtpRequest>): Response<SimpleApiResponse<SendOtpResponse>>

    suspend fun verifyOtp(request: SendRequest<VerifyOtpRequest>): Response<SimpleApiResponse<VerifyOtpResponse>>

    suspend fun updateProfile(
        authorization: String,
        request: SendRequest<UpdateProfileRequest>
    ): Response<SimpleApiResponse<ProfileData>>

    suspend fun signupApi(request: SendRequest<SignupRequest>): Response<SimpleApiResponse<SignupResponse>>

    suspend fun getPendingList(authorization: String): Response<SimpleApiResponse<List<PendingOrdersBean>>>

    suspend fun getProcessingList(
        authorization: String, status: String
    ): Response<SimpleApiResponse<ProcessingOrdersBean>>

    suspend fun updateStatus(
        authorization: String,
        request: SendRequest<UpdateStatus>
    ): Response<SimpleApiResponse<AcceptDeclineResponse>>

    suspend fun updateLocation(
        authorization: String,
        request: RequestBody
    ): Response<SimpleApiResponse<AcceptDeclineResponse>>

    suspend fun getProfileData(
        authorization: String
    ): Response<SimpleApiResponse<ProfileData>>

    suspend fun updateOnline(
        authorization: String,
        request: OnlineStatus
    ): Response<SimpleApiResponse<OnlineStatusData>>

    suspend fun updateNotification(
        authorization: String,
        request: EnableNotification
    ): Response<SimpleApiResponse<ProfileData>>

    suspend fun logOutApi(
        authorization: String
    ): Response<SimpleApiResponse<LogoutResponse>>

    suspend fun uploadImage(
        request: SendRequest<UploadRequest>
    ): Response<SimpleApiResponse<ImageUploadResponse>>

}