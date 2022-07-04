package com.rk.riggle_sales.data.request

import com.google.gson.annotations.SerializedName

class SendRequest<T> {
    @SerializedName("payload")
    var payload: T? = null
}