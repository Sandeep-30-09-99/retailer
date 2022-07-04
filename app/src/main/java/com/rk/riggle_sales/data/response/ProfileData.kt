package com.rk.riggle_sales.data.response

data class ProfileData(
    val profileData: UserDetails
)

data class UserDetails(
    val __v: Int,
    val _id: String,
    val carBackPhoto: String,
    val carFrontPhoto: String,
    val carModel: String,
    val carProductionYear: String,
    val carRegistertaionBackPhoto: String,
    val carRegistertaionFrontPhoto: String,
    val citizinship: String,
    val countryCode: String,
    val createdAt: String,
    val currentLocation: CurrentLocation,
    val deviceToken: String,
    val deviceType: Int,
    val driveLicenseBackPhoto: String,
    val driveLicenseFrontPhoto: String,
    val driveLicenseNumber: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val mobileNumber: Long,
    val nationalId: Any,
    val nationalIdBackPhoto: String,
    val nationalIdFrontPhoto: String,
    val otp: Int,
    val otpCreatedAtMilli: Long,
    val otpVerified: Boolean,
    val referralCode: String,
    val signUpCompleted: Boolean,
    val updatedAt: String,
    val vehiclePlateLetter: String,
    val vehiclePlateNumber: String,
    val vehicleType: String,
    val workingCity: String,
    val workingRegion: String,
    val livingAddress: String,
    val isonline: Boolean,
    val notify: Boolean,
    val profilepic: String?,
    val number: Long?,
    val evidence_of_vaccination: String
)

data class CurrentLocation(
    val coordinates: List<Double>,
    val type: String
)