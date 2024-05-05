package com.swaasth.partner.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swaasth.partner.ui.presentation.home.NotificationsScreen
import com.swaasth.partner.ui.presentation.home.QrScannerScreen
import com.swaasth.partner.ui.presentation.view_details.ViewDetailsScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.HOME,
        startDestination = HomeGraph.PatientDetails.route
    ) {
        composable(HomeGraph.PatientDetails.route) {
            ViewDetailsScreen {
                navController.popBackStack()
            }
        }

        composable(HomeGraph.Notifications.route) {
            NotificationsScreen()
        }

        composable(HomeGraph.QrScanner.route) {
            QrScannerScreen()
        }
    }
}

sealed class HomeGraph(val route: String) {
    data object PatientDetails : HomeGraph("PATIENT_DETAILS")
    data object Notifications : HomeGraph("NOTIFICATIONS")
    data object QrScanner : HomeGraph("QR_SCANNER")
}