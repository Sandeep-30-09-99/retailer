package com.rk.riggle_sales.data.response

data class ImageUploadResponse(
    val AWSSignedUrl: List<String>,
    val fileUrl: String
)