package com.thedone.ordersyncapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object LoginRoute

@Serializable
object OrderListRoute

@Serializable
data class OrderDetailRoute(val id: String)