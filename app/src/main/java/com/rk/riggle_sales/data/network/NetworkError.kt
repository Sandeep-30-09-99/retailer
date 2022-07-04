package com.rk.riggle_sales.data.network

class NetworkError(val errorCode: Int, override val message: String?) : Throwable(message)
