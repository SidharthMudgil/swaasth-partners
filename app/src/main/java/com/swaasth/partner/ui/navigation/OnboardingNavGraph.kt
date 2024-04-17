package com.swaasth.partner.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swaasth.partner.ui.presentation.onboarding.component.PersonalDetailsView
import com.swaasth.partner.ui.presentation.onboarding.component.QualificationDetailsView
import com.swaasth.partner.ui.presentation.onboarding.component.VerificationDetailsView

fun NavGraphBuilder.onboardingNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.ONBOARDING,
        startDestination = OnboardingGraph.PersonalDetails.route
    ) {
        composable(OnboardingGraph.PersonalDetails.route) {
            PersonalDetailsView()
        }

        composable(OnboardingGraph.QualificationDetails.route) {
            QualificationDetailsView()
        }

        composable(OnboardingGraph.VerificationDetails.route) {
            VerificationDetailsView()
        }

        // todo add the onboarding screen and go to next graph
    }
}

sealed class OnboardingGraph(val route: String) {
    data object PersonalDetails : OnboardingGraph("PERSONAL_DETAILS")
    data object QualificationDetails : OnboardingGraph("QUALIFICATION_DETAILS")
    data object VerificationDetails : OnboardingGraph("VERIFICATION_DETAILS")
}