package com.thedone.ordersyncapp.presentation.order

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thedone.ordersyncapp.domain.model.Order
import com.thedone.ordersyncapp.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val repository: OrderRepository,
) : ViewModel() {

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders = _orders.asStateFlow()

    init {
        fetchOrders()
    }

    private fun fetchOrders() {
        viewModelScope.launch {
            try {
                val result = repository.getOrders()
                _orders.value = result
            } catch (e: Exception) {
                Log.e("OrderViewModel", "Veri çekilemedi: ${e.localizedMessage}")
                e.printStackTrace()
            }
        }
    }
}