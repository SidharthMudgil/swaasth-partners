package com.swaasth.partner.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swaasth.partner.ui.presentation.onboarding.OnboardingScreen
import com.swaasth.partner.ui.presentation.onboarding.PersonalDetailsScreen
import com.swaasth.partner.ui.presentation.onboarding.QualificationDetailsScreen
import com.swaasth.partner.ui.presentation.onboarding.VerificationDetailsScreen

fun NavGraphBuilder.onboardingNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.ONBOARDING,
        startDestination = OnboardingGraph.PersonalDetails.route
    ) {
        composable(OnboardingGraph.PersonalDetails.route) {
            PersonalDetailsScreen {
                navController.navigate(OnboardingGraph.QualificationDetails.route)
            }
        }

        composable(OnboardingGraph.QualificationDetails.route) {
            QualificationDetailsScreen(
                onClick = {
                          navController.navigate(OnboardingGraph.VerificationDetails.route)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(OnboardingGraph.VerificationDetails.route) {
            VerificationDetailsScreen(onClick = {
                navController.navigate(OnboardingGraph.Onboarding.route) {
                    popUpTo(OnboardingGraph.VerificationDetails.route) {
                        inclusive = true
                    }
                }
            }, onBackClick = {
                navController.popBackStack()
            })
        }

        composable(OnboardingGraph.Onboarding.route) {
            OnboardingScreen {
                navController.navigate(Graph.MAIN) {
                    popUpTo(Graph.ONBOARDING) {
                        inclusive = true
                    }
                }
            }
        }
    }
}

sealed class OnboardingGraph(val route: String) {
    data object PersonalDetails : OnboardingGraph("PERSONAL_DETAILS")
    data object QualificationDetails : OnboardingGraph("QUALIFICATION_DETAILS")
    data object VerificationDetails : OnboardingGraph("VERIFICATION_DETAILS")
    data object Onboarding : OnboardingGraph("ONBOARDING")
}