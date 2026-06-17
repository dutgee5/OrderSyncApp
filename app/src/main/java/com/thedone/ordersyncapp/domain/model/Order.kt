package com.thedone.ordersyncapp.domain.model

data class Order(
    val id: String,
    val type: String,
    val items: List<String>,
    val remainingTimeMinutes: Int?,
)
