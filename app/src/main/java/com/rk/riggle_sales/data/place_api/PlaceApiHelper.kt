package com.rk.riggle_sales.data.place_api

import com.rk.riggle_sales.data.response.DirectionBean
import retrofit2.Response

interface PlaceApiHelper {
    suspend fun getDirection(map: Map<String, String>): Response<DirectionBean>
}