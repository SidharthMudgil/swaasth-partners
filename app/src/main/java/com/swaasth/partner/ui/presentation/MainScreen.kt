package com.swaasth.partner.ui.presentation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.swaasth.partner.ui.navigation.Graph
import com.swaasth.partner.ui.navigation.HomeGraph
import com.swaasth.partner.ui.navigation.LiveQueueGraph
import com.swaasth.partner.ui.navigation.ProfileGraph
import com.swaasth.partner.ui.navigation.component.BottomNavItem
import com.swaasth.partner.ui.navigation.homeNavGraph
import com.swaasth.partner.ui.navigation.liveQueueNavGraph
import com.swaasth.partner.ui.navigation.profileNavGraph
import com.swaasth.partner.ui.presentation.add_patient.AddPatientScreen
import com.swaasth.partner.ui.presentation.home.HomeScreen
import com.swaasth.partner.ui.presentation.profile.ProfileScreen
import com.swaasth.partner.ui.presentation.queue.LiveQueueScreen

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            route = Graph.MAIN,
            modifier = Modifier.padding(it)
        ) {
            composable(BottomNavItem.Home.route) {
                HomeScreen(
                    onQrClick = {},
                    onNotificationClick = {
                        navController.navigate(HomeGraph.Notifications.route)
                    },
                    onDoctorClick = {
                        navController.navigate(HomeGraph.PatientDetails.route)
                    }
                )
            }
            composable(BottomNavItem.AddPatient.route) {
                AddPatientScreen()
            }
            composable(BottomNavItem.LiveQueue.route) {
                LiveQueueScreen {
                    navController.navigate(LiveQueueGraph.PatientDetails.route)
                }
            }
            composable(BottomNavItem.Profile.route) {
                ProfileScreen(
                    onMediaClick = {},
                    onEditClick = {
                        navController.navigate(ProfileGraph.EditProfile.route)
                    },
                    onHistoryClick = {
                        navController.navigate(ProfileGraph.BookingHistory.route)
                    }
                )
            }
            liveQueueNavGraph(navController)
            homeNavGraph(navController)
            profileNavGraph(navController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.AddPatient,
        BottomNavItem.LiveQueue,
        BottomNavItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.height(60.dp),
    ) {
        items.forEach { item ->
            NavigationBarItem(
                alwaysShowLabel = false,
                icon = { Icon(item.icon, contentDescription = item.route) },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    BottomNavigationBar(rememberNavController())
}