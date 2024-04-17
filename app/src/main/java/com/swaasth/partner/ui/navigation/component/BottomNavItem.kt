package com.swaasth.partner.ui.navigation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector
) {
    data object Home : BottomNavItem(
        "Home", Icons.Rounded.Home
    )

    data object AddPatient : BottomNavItem(
        "Add Patient", Icons.Rounded.PersonAdd
    )

    data object LiveQueue : BottomNavItem(
        "Queue", Icons.Rounded.Groups
    )

    data object Profile : BottomNavItem(
        "Profile", Icons.Rounded.Person
    )
}