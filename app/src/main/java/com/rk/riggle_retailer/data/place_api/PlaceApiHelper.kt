package com.rk.riggle_retailer.data.place_api

import com.rk.riggle_retailer.data.response.DirectionBean
import retrofit2.Response

interface PlaceApiHelper {
    suspend fun getDirection(map: Map<String, String>): Response<DirectionBean>
}