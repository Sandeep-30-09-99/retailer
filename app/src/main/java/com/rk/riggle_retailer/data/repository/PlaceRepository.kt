package com.rk.riggle_retailer.data.repository

import com.rk.riggle_retailer.data.place_api.PlaceApiHelper
import javax.inject.Inject

class PlaceRepository @Inject constructor(private val apiPlaceHelper: PlaceApiHelper) {
    suspend fun getDirection(map: Map<String, String>) = apiPlaceHelper.getDirection(map)
}