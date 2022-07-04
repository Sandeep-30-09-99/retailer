package com.rk.riggle_retailer.data.network

class NetworkError(val errorCode: Int, override val message: String?) : Throwable(message)
