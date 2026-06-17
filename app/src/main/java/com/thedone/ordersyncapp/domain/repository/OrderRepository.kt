package com.thedone.ordersyncapp.domain.repository

import com.thedone.ordersyncapp.domain.model.Order


interface OrderRepository {
    suspend fun getOrders(): List<Order>
}