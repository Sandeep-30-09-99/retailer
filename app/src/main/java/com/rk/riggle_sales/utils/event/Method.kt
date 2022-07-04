package com.rk.riggle_sales.utils.event

import com.rk.riggle_sales.di.base.SimpleApiResponse
import retrofit2.Response

abstract class Method<T> {
    open suspend fun getSimpleApiMethod(token: String?): Response<SimpleApiResponse<T>>? {
        return null
    }

}