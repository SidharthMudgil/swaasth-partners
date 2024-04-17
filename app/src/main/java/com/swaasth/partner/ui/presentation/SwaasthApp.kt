package com.swaasth.partner.ui.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.swaasth.partner.ui.navigation.RootNavigationGraph
import com.swaasth.partner.ui.theme.SwaasthTheme

@Composable
fun SwaasthApp(
    navController: NavHostController
) {
    SwaasthTheme {
        RootNavigationGraph(navController)
    }
}