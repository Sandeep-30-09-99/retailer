package com.rk.riggle_retailer.data.model


data class MenuBean(
    var id: Int,
    var name: String,
    var image: Int,
    var check: Boolean = false
)