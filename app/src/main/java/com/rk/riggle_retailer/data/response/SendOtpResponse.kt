package com.rk.riggle_retailer.data.response

data class SendOtpResponse(val userId: String)

data class VerifyOtpResponse(
    val verified: Boolean,
    val signUpCompleted: Boolean,
    val accessToken: String
)

data class SignupResponse(
    val signup: Boolean,
    val accessToken: String
)

data class UpdateProfileResponse(val userId: String)