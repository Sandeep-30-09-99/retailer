package com.rk.riggle_sales.utils.location

import android.location.Location

interface LocationResultListener {
    fun getLocation(location: Location)
}