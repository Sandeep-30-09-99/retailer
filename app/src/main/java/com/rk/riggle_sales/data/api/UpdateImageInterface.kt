package com.rk.riggle_sales.data.api

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface UpdateImageInterface {
    @Headers("Content-Type:image/png")
    @PUT
    fun updateImage(@Url url: String, @Body image: RequestBody): Call<Void>
}