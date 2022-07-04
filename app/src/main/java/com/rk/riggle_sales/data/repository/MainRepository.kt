package com.rk.riggle_sales.data.repository

import com.rk.riggle_sales.data.api.ApiHelper
import com.rk.riggle_sales.data.request.*
import com.rk.riggle_sales.data.response.AcceptDeclineResponse
import com.rk.riggle_sales.data.response.OnlineStatusData
import com.rk.riggle_sales.data.response.ProfileData
import com.rk.riggle_sales.di.base.SimpleApiResponse
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

    suspend fun sendOtp(request: SendRequest<SendOtpRequest>) = apiHelper.sendOtp(request)

    suspend fun verifyOtp(request: SendRequest<VerifyOtpRequest>) = apiHelper.verifyOtp(request)

    suspend fun updateProfile(authorization: String, request: SendRequest<UpdateProfileRequest>) =
        apiHelper.updateProfile(authorization, request)

    suspend fun signupApi(request: SendRequest<SignupRequest>) = apiHelper.signupApi(request)

    suspend fun getPendingList(authorization: String) = apiHelper.getPendingList(authorization)

    suspend fun getProcessingList(
        authorization: String,
        status: String
    ) = apiHelper.getProcessingList(authorization, status)

    suspend fun updateStatus(
        authorization: String,
        request: SendRequest<UpdateStatus>
    ) = apiHelper.updateStatus(authorization, request)

    suspend fun updateLocation(
        authorization: String,
        request: RequestBody
    ): Response<SimpleApiResponse<AcceptDeclineResponse>> =
        apiHelper.updateLocation(authorization, request)

    suspend fun getProfileData(
        authorization: String
    ): Response<SimpleApiResponse<ProfileData>> = apiHelper.getProfileData(authorization)

    suspend fun updateOnline(
        authorization: String,
        request: OnlineStatus
    ): Response<SimpleApiResponse<OnlineStatusData>> =
        apiHelper.updateOnline(authorization, request)

    suspend fun updateNotification(
        authorization: String,
        request: EnableNotification
    ) = apiHelper.updateNotification(authorization, request)

    suspend fun logOutApi(authorization: String) = apiHelper.logOutApi(authorization)

    suspend fun uploadImage(request: SendRequest<UploadRequest>) = apiHelper.uploadImage(request)

}