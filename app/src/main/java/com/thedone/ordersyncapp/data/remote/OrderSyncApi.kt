package com.thedone.ordersyncapp.data.remote

import com.thedone.ordersyncapp.data.LoginResponse
import com.thedone.ordersyncapp.data.remote.dto.OrderDto
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderSyncApi {
    @POST("auth/login")
    suspend fun login(): LoginResponse

    @GET("v1/ad3ea447-e9e8-4cda-819e-cdabea8086eb")
    suspend fun getPendingOrders(): List<OrderDto   >

    companion object {
        const val BASE_URL = "https://mocki.io/"
    }
}