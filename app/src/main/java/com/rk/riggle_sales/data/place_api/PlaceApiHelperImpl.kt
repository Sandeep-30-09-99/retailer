package com.rk.riggle_sales.data.place_api

import com.rk.riggle_sales.data.response.DirectionBean
import retrofit2.Response
import javax.inject.Inject

class PlaceApiHelperImpl @Inject constructor(
    private val apiService: PlaceApiService
) : PlaceApiHelper {
    override suspend fun getDirection(map: Map<String, String>): Response<DirectionBean> {
        return apiService.getDirection(map)
    }
}