package com.rk.riggle_sales.data.request

data class SendOtpRequest(
    var mobileNumber: Long,
    var countryCode: String,
    var deviceToken: String,
    var deviceType: Int
)

data class VerifyOtpRequest(
    var mobileNumber: Long,
    var otp: Int,
    var userId: String
)

data class SignupRequest(
    var firstName: String,
    var lastName: String,
    var email: String,
    var referralCode: String,
    var userId: String
)

data class UpdateProfileRequest(
    var carBackPhoto: String = "",
    var carFrontPhoto: String = "",
    var carModel: String,
    var email: String,
    var carProductionYear: String,
    var carRegistertaionBackPhoto: String = "",
    var carRegistertaionFrontPhoto: String = "",
    var citizinship: String,
    var driveLicenseBackPhoto: String = "",
    var driveLicenseFrontPhoto: String = "",
    var driveLicenseNumber: String,
    var firstName: String,
    var lastName: String,
    var nationalIdBackPhoto: String = "",
    var nationalIdFrontPhoto: String = "",
    var nationalIdPhoto: String = "",
    var nationalId: String = "",
    var userId: String,
    var vehiclePlateLetter: String,
    var vehiclePlateNumber: String,
    var vehicleType: String,
    var workingCity: String,
    var workingRegion: String,
    var livingAddress: String,
    var profilepic: String,
    var number: Long,
    var iqama: String,
    var evidence_of_vaccination: String
)

data class UpdateStatus(
    var orderId: String,
    var deliveryStatus: String,
    var deliveryHeroId: String
)

data class SendLocation(val location: SendLocationRequest)

data class SendLocationRequest(val coordinates: ArrayList<Double>)

data class OnlineStatus(var isonline: Boolean)

data class EnableNotification(var notify: Boolean)

data class UploadRequest(
    val contentType: String,
    val extension: String,
    val uploadType: String
)
