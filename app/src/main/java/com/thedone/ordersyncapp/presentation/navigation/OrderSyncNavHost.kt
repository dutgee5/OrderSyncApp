package com.thedone.ordersyncapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thedone.ordersyncapp.presentation.auth.LoginScreen
import com.thedone.ordersyncapp.presentation.auth.LoginState
import com.thedone.ordersyncapp.presentation.auth.LoginViewModel
import com.thedone.ordersyncapp.presentation.order.OrderScreen

@Composable
fun OrderSyncNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LoginRoute) {

        composable<LoginRoute> {

            val viewModel: LoginViewModel = hiltViewModel()

            val email by viewModel.email.collectAsStateWithLifecycle()
            val password by viewModel.password.collectAsStateWithLifecycle()
            val loginState by viewModel.loginState.collectAsStateWithLifecycle()

            LaunchedEffect(loginState) {
                if (loginState is LoginState.Success) {
                    navController.navigate(OrderListRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                }
            }


            LoginScreen(
                email = email,
                password = password,
                loginState = loginState,
                onEmailChange = viewModel::onEmailChange,
                onPasswordChange = viewModel::onPasswordChange,
                onLoginClick = { viewModel.login() }
            )
        }

        composable<OrderListRoute> {
            OrderScreen()
        }
    }
}