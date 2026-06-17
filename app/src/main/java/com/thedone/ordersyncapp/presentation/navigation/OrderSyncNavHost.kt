package com.thedone.ordersyncapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thedone.ordersyncapp.presentation.auth.LoginScreen
import com.thedone.ordersyncapp.presentation.order.OrderScreen

@Composable
fun OrderSyncNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LoginRoute) {

        composable<LoginRoute> {
            LoginScreen(onLoginClick = {
                navController.navigate(OrderListRoute) {
                    popUpTo(LoginRoute) {
                        inclusive = true
                    }
                }
            })
        }

        composable<OrderListRoute> {
            OrderScreen()
        }
    }
}