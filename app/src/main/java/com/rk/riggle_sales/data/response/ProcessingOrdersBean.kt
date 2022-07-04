package com.rk.riggle_sales.data.response

data class ProcessingOrdersBean(val orderItem: List<OrderItemsBean>)

data class OrderItemsBean(
    val _id: String,
    val cartItems: List<CartItem>,
    val cookieMonsterId: String,
    val deliveryStatus: String,
    val deliveryType: String,
    val distance: String,
    val orderId: String,
    val orderStatus: String,
    val payWith: String,
    val payableAmount: Double,
    val restaurantId: RestaurantId,
    val time: String,
    val totalAmount: Double,
    val totaltime: String,
    val cookieMonsterDetail: CookieMonsterDetail,
    val deliveryheroLocation: DeliveryheroLocation
)

data class DeliveryheroLocation(
    val latitude: Double,
    val longitude: Double
)
