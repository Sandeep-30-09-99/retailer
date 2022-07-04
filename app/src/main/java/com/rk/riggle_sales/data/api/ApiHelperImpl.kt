package com.rk.riggle_sales.data.api

import com.rk.riggle_sales.data.model.User
import com.rk.riggle_sales.data.request.*
import com.rk.riggle_sales.data.response.*
import com.rk.riggle_sales.di.base.SimpleApiResponse
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

    override suspend fun sendOtp(request: SendRequest<SendOtpRequest>): Response<SimpleApiResponse<SendOtpResponse>> {
        return apiService.sendOtp(request)
    }

    override suspend fun verifyOtp(request: SendRequest<VerifyOtpRequest>): Response<SimpleApiResponse<VerifyOtpResponse>> {
        return apiService.verifyOtp(request)
    }

    override suspend fun updateProfile(
        authorization: String,
        request: SendRequest<UpdateProfileRequest>
    ): Response<SimpleApiResponse<ProfileData>> {
        return apiService.updateProfile(authorization, request)
    }

    override suspend fun signupApi(request: SendRequest<SignupRequest>): Response<SimpleApiResponse<SignupResponse>> {
        return apiService.signupApi(request)
    }

    override suspend fun getPendingList(authorization: String): Response<SimpleApiResponse<List<PendingOrdersBean>>> {
        return apiService.getPendingList(authorization)
    }

    override suspend fun getProcessingList(
        authorization: String,
        status: String
    ): Response<SimpleApiResponse<ProcessingOrdersBean>> {
        return apiService.getProcessingList(authorization, status)
    }

    override suspend fun updateStatus(
        authorization: String,
        request: SendRequest<UpdateStatus>
    ): Response<SimpleApiResponse<AcceptDeclineResponse>> {
        return apiService.updateStatus(authorization, request)
    }

    override suspend fun updateLocation(
        authorization: String,
        request: RequestBody
    ): Response<SimpleApiResponse<AcceptDeclineResponse>> {
        return apiService.updateLocation(authorization, request)
    }

    override suspend fun getProfileData(authorization: String): Response<SimpleApiResponse<ProfileData>> {
        return apiService.getProfileData(authorization)
    }

    override suspend fun updateOnline(
        authorization: String,
        request: OnlineStatus
    ): Response<SimpleApiResponse<OnlineStatusData>> {
        return apiService.updateOnline(authorization, request)
    }

    override suspend fun updateNotification(
        authorization: String,
        request: EnableNotification
    ): Response<SimpleApiResponse<ProfileData>> {
        return apiService.updateNotification(authorization, request)
    }

    override suspend fun logOutApi(authorization: String): Response<SimpleApiResponse<LogoutResponse>> {
        return apiService.logOutApi(authorization)
    }

    override suspend fun uploadImage(request: SendRequest<UploadRequest>): Response<SimpleApiResponse<ImageUploadResponse>> {
        return apiService.uploadImage(request)
    }

}