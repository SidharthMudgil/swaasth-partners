package com.swaasth.partner.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swaasth.partner.ui.presentation.view_details.ViewDetailsScreen

fun NavGraphBuilder.liveQueueNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.LIVE_QUEUE,
        startDestination = LiveQueueGraph.PatientDetails.route
    ) {
        composable(LiveQueueGraph.PatientDetails.route) {
            ViewDetailsScreen({})
        }
    }
}

sealed class LiveQueueGraph(val route: String) {
    data object PatientDetails : LiveQueueGraph("PATIENT_DETAILS")
}