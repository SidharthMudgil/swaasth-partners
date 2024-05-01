package com.swaasth.partner.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swaasth.partner.ui.presentation.profile.BookingHistoryScreen
import com.swaasth.partner.ui.presentation.profile.EditProfileScreen

fun NavGraphBuilder.profileNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileGraph.EditProfile.route
    ) {
        composable(ProfileGraph.EditProfile.route) {
            EditProfileScreen(
                onClick = { navController.popBackStack() },
                onBackClick = { navController.popBackStack() })
        }

        composable(ProfileGraph.BookingHistory.route) {
            BookingHistoryScreen {
                navController.popBackStack()
            }
        }
    }
}

sealed class ProfileGraph(val route: String) {
    data object EditProfile : ProfileGraph("EDIT_PROFILE")
    data object BookingHistory : ProfileGraph("BOOKING_HISTORY")
}