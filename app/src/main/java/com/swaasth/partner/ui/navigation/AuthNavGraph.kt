package com.swaasth.partner.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swaasth.partner.ui.presentation.login.LoginScreen
import com.swaasth.partner.ui.presentation.login.OtpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthGraph.Login.route
    ) {
        composable(AuthGraph.Login.route) {
            LoginScreen()
        }

        composable(AuthGraph.OTP.route) {
            OtpScreen()
        }

//        onboardingNavGraph()
    }
}

sealed class AuthGraph(val route: String) {
    data object Login : AuthGraph("LOGIN")
    data object OTP : AuthGraph("OTP")
}