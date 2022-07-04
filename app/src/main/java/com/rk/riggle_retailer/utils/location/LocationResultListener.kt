package com.rk.riggle_retailer.utils.location

import android.location.Location

interface LocationResultListener {
    fun getLocation(location: Location)
}