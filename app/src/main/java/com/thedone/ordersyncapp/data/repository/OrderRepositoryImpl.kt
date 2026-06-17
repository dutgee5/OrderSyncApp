package com.thedone.ordersyncapp.data.repository

import com.thedone.ordersyncapp.data.remote.OrderSyncApi
import com.thedone.ordersyncapp.data.remote.dto.OrderDto
import com.thedone.ordersyncapp.data.remote.dto.toOrder
import com.thedone.ordersyncapp.domain.model.Order
import com.thedone.ordersyncapp.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val api: OrderSyncApi,
) : OrderRepository {

    override suspend fun getOrders(): List<Order> {
        val dbList = api.getPendingOrders()

        return dbList.map { it.toOrder() }
    }

}