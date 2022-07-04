package com.rk.riggle_retailer.data.response

data class ImageUploadResponse(
    val AWSSignedUrl: List<String>,
    val fileUrl: String
)