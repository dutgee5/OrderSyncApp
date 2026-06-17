package com.thedone.ordersyncapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.thedone.ordersyncapp.domain.model.Order


data class OrderDto(
    @SerializedName("orderId") val orderId: String?,
    @SerializedName("packegeType") val packegeType: String?,
    @SerializedName("items") val items: List<String>?,
    @SerializedName("remainingTimeMinutes") val remainingTimeMinutes: Int?,
)

fun OrderDto.toOrder(): Order {
    return Order(
        id = this.orderId ?: "ORD-0",
        type = this.packegeType ?: "Bilinmeyen Koli",
        items = this.items ?: emptyList(),
        remainingTimeMinutes = this.remainingTimeMinutes ?: 0
    )
}