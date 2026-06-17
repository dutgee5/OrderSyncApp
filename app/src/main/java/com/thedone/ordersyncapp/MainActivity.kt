package com.thedone.ordersyncapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.thedone.ordersyncapp.presentation.navigation.OrderSyncNavHost
import com.thedone.ordersyncapp.presentation.theme.OrderSyncAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrderSyncAppTheme {
                OrderSyncNavHost()
            }
        }
    }
}

